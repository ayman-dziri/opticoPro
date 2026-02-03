package com.opticpro.opticpro.dto.visit_type;

import com.opticpro.opticpro.dto.eye.EyeDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class VisitTypeDto {

    private List<EyeDto> eyes = new ArrayList<>();

}
