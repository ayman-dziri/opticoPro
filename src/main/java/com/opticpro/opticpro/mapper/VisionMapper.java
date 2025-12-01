package com.opticpro.opticpro.mapper;

import com.opticpro.opticpro.dto.vision.VisionDto;
import com.opticpro.opticpro.entity.vision.Vision;
import com.opticpro.opticpro.entity.vision.VisionF;
import com.opticpro.opticpro.entity.vision.VisionN;

public class VisionMapper {

    public static Vision mapToVision(VisionDto visionDto, String type) {
        Vision vision;
        if(type.equalsIgnoreCase("F"))  vision = new VisionF();
        else if(type.equalsIgnoreCase("N")) vision = new VisionN();
        else throw new IllegalArgumentException("ce type n'existe pas");

        vision.setSphere(visionDto.getSphere());
        vision.setCylinder(visionDto.getCylinder());
        vision.setAxe(visionDto.getAxe());
        vision.setAddition(visionDto.getAddition());

        return vision;
    }

    public static VisionDto mapToVisionDto(Vision vision) {
        VisionDto visionDto = new VisionDto();
        visionDto.setSphere(vision.getSphere());
        visionDto.setCylinder(vision.getCylinder());
        visionDto.setAxe(vision.getAxe());
        visionDto.setAddition(vision.getAddition());
        return visionDto;
    }
}
