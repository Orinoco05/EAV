package com.example.sinhvieneav.service.dto;

import com.example.sinhvieneav.domain.EntityMeta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeMetaDTO {
    private Long attributeMetaId;
    private Long entityMetaId;
    private String name;
    private String datatype;

}

