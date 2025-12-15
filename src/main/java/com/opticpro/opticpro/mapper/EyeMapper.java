package com.opticpro.opticpro.mapper;

import com.opticpro.opticpro.dto.eye.EyeDto;
import com.opticpro.opticpro.entity.eye.Eye;
import com.opticpro.opticpro.entity.eye.EyeL;
import com.opticpro.opticpro.entity.eye.EyeR;

public class EyeMapper {

    public static Eye MapToEntity(EyeDto eyeDto, String type){

        Eye eye;
        if(type.equalsIgnoreCase("R"))  eye = new EyeR();
        else if (type.equalsIgnoreCase("L"))  eye = new EyeL();
        else throw new IllegalArgumentException("type d'oeil non valide");

        eye.setDistance(eyeDto.getDistance());
        eye.setHeight(eyeDto.getHeight());
        eye.setLentille(eyeDto.getLentille());
        eye.setVisions(eyeDto.getVisions());

        return eye;
    }

    public static EyeDto mapToEyeDto(Eye eye){

        EyeDto eyeDto = new EyeDto();
        eyeDto.setDistance(eye.getDistance());
        eyeDto.setHeight(eye.getHeight());
        eyeDto.setLentille(eye.getLentille());
        eyeDto.setVisions(eye.getVisions());
        return eyeDto;
    }
}
