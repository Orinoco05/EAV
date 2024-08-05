package com.example.sinhvieneav.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityAttributeValueDTO {
    private Long entityInstanceId;
    private Long attributeMetaId;
    private String value; // Changed from Text to String
    private String dataType;
    private Long entityAttributeValueId;
}
