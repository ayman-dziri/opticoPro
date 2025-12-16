package com.opticpro.opticpro.mapper;

import com.opticpro.opticpro.dto.eye.EyeDto;
import com.opticpro.opticpro.dto.vision.VisionDto;
import com.opticpro.opticpro.entity.eye.Eye;
import com.opticpro.opticpro.entity.eye.EyeL;
import com.opticpro.opticpro.entity.eye.EyeR;
import com.opticpro.opticpro.entity.vision.Vision;

import java.util.ArrayList;
import java.util.List;

public class EyeMapper {

    public static Eye MapToEntity(EyeDto eyeDto, String type){

        Eye eye;
        if(type.equalsIgnoreCase("R"))  eye = new EyeR();
        else if (type.equalsIgnoreCase("L"))  eye = new EyeL();
        else throw new IllegalArgumentException("type d'oeil non valide");

        eye.setDistance(eyeDto.getDistance());
        eye.setHeight(eyeDto.getHeight());
        eye.setLentille(eyeDto.getLentille());

        return eye;
    }

    public static EyeDto mapToEyeDto(Eye eye){

        EyeDto eyeDto = new EyeDto();
        eyeDto.setDistance(eye.getDistance());
        eyeDto.setHeight(eye.getHeight());
        eyeDto.setLentille(eye.getLentille());
        return eyeDto;
    }
}
