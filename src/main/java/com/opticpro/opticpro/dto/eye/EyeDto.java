package com.opticpro.opticpro.dto.eye;

import com.opticpro.opticpro.dto.vision.VisionDto;
import com.opticpro.opticpro.entity.vision.Vision;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class EyeDto {

    private byte distance;

    private byte height;

    private byte lentille;

    private List<VisionDto> visions = new ArrayList<>();
}