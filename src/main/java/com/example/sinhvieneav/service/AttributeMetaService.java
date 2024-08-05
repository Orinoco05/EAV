package com.example.sinhvieneav.service;

import com.example.sinhvieneav.domain.AttributeMeta;
import com.example.sinhvieneav.domain.EntityMeta;
import com.example.sinhvieneav.exception.ResourceNotFoundException;
import com.example.sinhvieneav.repository.AttributeMetaRepository;
import com.example.sinhvieneav.repository.EntityMetaRepository;
import com.example.sinhvieneav.service.dto.AttributeMetaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AttributeMetaService {
    private final AttributeMetaRepository attributeMetaRepository;
    private EntityMetaRepository entityMetaRepository;
    public List<AttributeMetaDTO> getAllAttributeMetas() {
        return attributeMetaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AttributeMetaDTO getAttributeMetaById(Long id) {
        AttributeMeta attributeMeta = attributeMetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AttributeMeta not found"));
        return convertToDTO(attributeMeta);
    }

    public AttributeMetaDTO createAttributeMeta(AttributeMetaDTO attributeMetaDTO) {
        AttributeMeta attributeMeta = new AttributeMeta();

        EntityMeta entityMeta = entityMetaRepository.findById(attributeMetaDTO.getEntityMetaId())
                .orElseThrow(() -> new ResourceNotFoundException("EntityMeta not found"));
        attributeMeta.setEntityMeta(entityMeta);
        attributeMeta.setName(attributeMetaDTO.getName());
        attributeMeta.setDatatype(attributeMetaDTO.getDatatype());
        attributeMeta.setAttributeMetaId(attributeMetaDTO.getAttributeMetaId());
        attributeMeta.setEntityMeta(entityMeta);
        System.out.println(attributeMeta);
        attributeMeta = attributeMetaRepository.save(attributeMeta);
        return convertToDTO(attributeMeta);
    }

    public AttributeMetaDTO updateAttributeMeta(Long id, AttributeMetaDTO attributeMetaDTO) {
        AttributeMeta attributeMeta = attributeMetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AttributeMeta not found"));
        attributeMeta.setName(attributeMetaDTO.getName());
        attributeMeta.setAttributeMetaId(attributeMetaDTO.getAttributeMetaId());
        attributeMeta.setDatatype(attributeMetaDTO.getDatatype());
        attributeMeta = attributeMetaRepository.save(attributeMeta);
        return convertToDTO(attributeMeta);
    }

    public void deleteAttributeMeta(Long id) {
        attributeMetaRepository.deleteById(id);
    }

    private AttributeMetaDTO convertToDTO(AttributeMeta attributeMeta) {
        AttributeMetaDTO dto = new AttributeMetaDTO();
        dto.setAttributeMetaId(attributeMeta.getAttributeMetaId());
        dto.setEntityMetaId(attributeMeta.getEntityMeta().getEntityMetaId());
        dto.setName(attributeMeta.getName());
        dto.setDatatype(attributeMeta.getDatatype());
        return dto;
    }

}