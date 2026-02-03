package com.opticpro.opticpro.service.vision;


import com.opticpro.opticpro.dto.vision.VisionDto;
import com.opticpro.opticpro.entity.vision.Vision;
import com.opticpro.opticpro.mapper.VisionMapper;
import com.opticpro.opticpro.repository.VisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisionServiceImpl implements VisionService{

    private final VisionRepository visionRepository;

    public VisionServiceImpl(VisionRepository visionRepository) {
        this.visionRepository = visionRepository;
    }

    public List<Vision> findAll() {
        return visionRepository.findAll();
    }

    public Vision getVisionById(int id) {
        return this.visionRepository.findById(id).orElse(null);
    }

    public Vision createVision(VisionDto visionDto, String type){
        Vision vision = VisionMapper.mapToVision(visionDto, type);
        return visionRepository.save(vision);
    }

    public List<Vision> createVisions(List<VisionDto> visionsDto){ // create the two visions
        if(visionsDto == null || visionsDto.isEmpty()){
            throw new IllegalArgumentException("vision can not be null or empty");
        }

        List<Vision> visions = new ArrayList<>();
        VisionDto firstVision = visionsDto.get(0);
        VisionDto secondVision = visionsDto.get(1);
        visions.add(this.createVision(firstVision, "F")); // far vision
        visions.add(this.createVision(secondVision, "N")); // near vision
        return visions;
    }

    public Vision updateVision(int id, VisionDto visionDto, String type){
        Vision vision = getVisionById(id);
        vision = VisionMapper.mapToVision(visionDto, type);
        return visionRepository.save(vision);
    }
}
