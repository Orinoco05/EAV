package com.example.sinhvieneav.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class EntityMetaDTO {
    private Long entityMetaId;
    private String name;
//    private List<AttributeMetaDTO> attributeMetaDTOS;
}


