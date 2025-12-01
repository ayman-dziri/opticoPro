package com.opticpro.opticpro.dto.vision;

import com.opticpro.opticpro.entity.eye.Eye;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class VisionDto {

    private byte sphere;

    private byte cylinder;

    private byte axe;

    private byte addition;

    private Eye eye;
}