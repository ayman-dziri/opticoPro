package com.opticpro.opticpro.service.vision;


import com.opticpro.opticpro.dto.vision.VisionDto;
import com.opticpro.opticpro.entity.vision.Vision;

import java.util.List;

public interface VisionService {
    List<Vision> findAll();
    Vision getVisionById(int id);
    Vision createVision(VisionDto visionDto, String type);
    Vision updateVision(int id, VisionDto visionDto, String type);
}
