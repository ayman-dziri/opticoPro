package com.opticpro.opticpro.service.eye;


import com.opticpro.opticpro.dto.eye.EyeDto;
import com.opticpro.opticpro.entity.eye.Eye;
import com.opticpro.opticpro.entity.vision.Vision;
import com.opticpro.opticpro.mapper.EyeMapper;
import com.opticpro.opticpro.repository.EyeRepository;
import com.opticpro.opticpro.service.vision.VisionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EyeServiceImpl implements EyeService {

    private final EyeRepository eyeRepository;
    private final VisionService visionService;

    public EyeServiceImpl(EyeRepository eyeRepository, VisionService visionService) {
        this.eyeRepository = eyeRepository;
        this.visionService = visionService;
    }

    public Eye createEye(EyeDto eyeDto, String type) {
        List<Vision> visions = this.visionService.createVisions(eyeDto.getVisions());
        Eye eye = EyeMapper.MapToEntity(eyeDto, type);
        eye.setVisions(visions);
        return this.eyeRepository.save(eye);
    }

    public List<Eye> createEyes(List<EyeDto> eyeDto) {
        List<Eye> eyes = new ArrayList<>();
        eyes.add(this.createEye(eyeDto.getFirst(), "R"));
        eyes.add(this.createEye(eyeDto.getFirst(), "L"));
        return eyes;
    }




    // 12pts mongoDB (50% find et 50% agregate) + QCM + casandra

}