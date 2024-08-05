package com.example.sinhvieneav.service;

import com.example.sinhvieneav.domain.EntityAttributeValue;
import com.example.sinhvieneav.repository.EntityAttributeValueRepository;
import com.example.sinhvieneav.repository.EntityInstanceRepository;
import com.example.sinhvieneav.repository.AttributeMetaRepository;
import com.example.sinhvieneav.service.dto.EntityAttributeValueDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityAttributeValueService {
    private final EntityAttributeValueRepository entityAttributeValueRepository;
    private final EntityInstanceRepository entityInstanceRepository;
    private final AttributeMetaRepository attributeMetaRepository;

    public EntityAttributeValueService(EntityAttributeValueRepository entityAttributeValueRepository,
                                       EntityInstanceRepository entityInstanceRepository,
                                       AttributeMetaRepository attributeMetaRepository) {
        this.entityAttributeValueRepository = entityAttributeValueRepository;
        this.entityInstanceRepository = entityInstanceRepository;
        this.attributeMetaRepository = attributeMetaRepository;
    }

    public List<EntityAttributeValueDTO> getAllEntityAttributeValueDTOs() {
        return entityAttributeValueRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public EntityAttributeValueDTO getEntityAttributeValueById(Long id) {
        return entityAttributeValueRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public EntityAttributeValueDTO saveEntityAttributeValue(EntityAttributeValueDTO entityAttributeValueDTO) {
        EntityAttributeValue entityAttributeValue = toEntity(entityAttributeValueDTO);
        EntityAttributeValue savedEntity = entityAttributeValueRepository.save(entityAttributeValue);
        return toDto(savedEntity);
    }

    public void deleteEntityAttributeValue(Long id) {
        entityAttributeValueRepository.deleteById(id);
    }

    private EntityAttributeValueDTO toDto(EntityAttributeValue entity) {
        if (entity == null) {
            return null;
        }

        EntityAttributeValueDTO dto = new EntityAttributeValueDTO();
        dto.setEntityAttributeValueId(entity.getEntityAttributeValueId());
        dto.setEntityInstanceId(entity.getEntityInstance() != null ? entity.getEntityInstance().getEntityInstanceId() : null);
        dto.setAttributeMetaId(entity.getAttributeMeta() != null ? entity.getAttributeMeta().getAttributeMetaId() : null);
        dto.setValue(entity.getValue());
        dto.setDataType(entity.getDataType());

        return dto;
    }

    private EntityAttributeValue toEntity(EntityAttributeValueDTO dto) {
        if (dto == null) {
            return null;
        }

        EntityAttributeValue entity = new EntityAttributeValue();
        entity.setEntityAttributeValueId(dto.getEntityAttributeValueId());
        entity.setEntityInstance(entityInstanceRepository.findById(dto.getEntityInstanceId()).orElse(null));
        entity.setAttributeMeta(attributeMetaRepository.findById(dto.getAttributeMetaId()).orElse(null));
        entity.setValue(dto.getValue());
        entity.setDataType(dto.getDataType());

        return entity;
    }
}
