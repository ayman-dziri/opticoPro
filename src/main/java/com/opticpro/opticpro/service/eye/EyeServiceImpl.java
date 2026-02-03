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

    public Eye createEye(EyeDto eyeDto, String type) { //create one eye with these visions
        List<Vision> visions = this.visionService.createVisions(eyeDto.getVisions()); // these visions
        Eye eye = EyeMapper.MapToEntity(eyeDto, type);
        eye.setVisions(visions); // add these visions
        return this.eyeRepository.save(eye);
    }

    public List<Eye> createEyes(List<EyeDto> eyeDto) { // create the two eyes
        if(eyeDto == null || eyeDto.isEmpty()){ // verify if the eyes are null
            throw new IllegalArgumentException("eyeDto cannot be null or empty");
        }

        List<Eye> eyes = new ArrayList<>();
        EyeDto firstEye = eyeDto.get(0);
        EyeDto secondEye = eyeDto.get(1);
        eyes.add(this.createEye(firstEye, "R")); // adding the right eye
        eyes.add(this.createEye(secondEye, "L")); // adding the left eye

        return eyes;
    }




    // 12pts mongoDB (50% find et 50% agregate) + QCM + casandra

}