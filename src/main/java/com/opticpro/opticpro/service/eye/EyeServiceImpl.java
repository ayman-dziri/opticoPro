package com.opticpro.opticpro.service.eye;


import com.opticpro.opticpro.dto.eye.EyeDto;
import com.opticpro.opticpro.entity.eye.Eye;
import com.opticpro.opticpro.mapper.EyeMapper;
import com.opticpro.opticpro.repository.EyeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EyeServiceImpl implements EyeService {

    private final EyeRepository eyeRepository;

    public EyeServiceImpl(EyeRepository eyeRepository) {
        this.eyeRepository = eyeRepository;
    }

    public List<Eye> createEye(EyeDto eyeDto) {
        Eye eyeR = EyeMapper.MapToEntity(eyeDto, "R");
        this.eyeRepository.save(eyeR);
        Eye eyeL = EyeMapper.MapToEntity(eyeDto, "L");
        this.eyeRepository.save(eyeL);
        List<Eye> eyes = new ArrayList<>();
        eyes.add(eyeL);
        eyes.add(eyeR);
        return eyes;
    }

}