package com.opticpro.opticpro.service.eye;

import com.opticpro.opticpro.dto.eye.EyeDto;
import com.opticpro.opticpro.entity.eye.Eye;

import java.util.List;

public interface EyeService {

    Eye createEye(EyeDto eyeDto, String type);
    List<Eye> createEyes(List<EyeDto> eyeDto);

}
