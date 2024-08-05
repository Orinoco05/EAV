package com.example.sinhvieneav.service;

import com.example.sinhvieneav.domain.EntityMeta;
import com.example.sinhvieneav.exception.ResourceNotFoundException;
import com.example.sinhvieneav.repository.EntityMetaRepository;
import com.example.sinhvieneav.service.dto.EntityMetaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityMetaService {
    private EntityMetaRepository entityMetaRepository;

    public EntityMetaService(EntityMetaRepository entityMetaRepository) {
        this.entityMetaRepository = entityMetaRepository;
    }

    public List<EntityMetaDTO> getAllEntityMetas() {
        return entityMetaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EntityMetaDTO getEntityMetaById(Long id) {
        return entityMetaRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("EntityMeta not found"));
    }

    public EntityMetaDTO saveEntityMeta(EntityMetaDTO entityMetaDTO) {
        EntityMeta entityMeta = convertToEntity(entityMetaDTO);
        entityMeta = entityMetaRepository.save(entityMeta);
        return convertToDTO(entityMeta);
    }

    public EntityMetaDTO updateEntityMeta(Long id, EntityMetaDTO entityMetaDTO) {
        EntityMeta entityMeta = entityMetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EntityMeta not found"));
        entityMeta.setName(entityMetaDTO.getName());
        entityMeta = entityMetaRepository.save(entityMeta);
        return convertToDTO(entityMeta);
    }

    public void deleteEntityMeta(Long id) {
        EntityMeta entityMeta = entityMetaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EntityMeta not found"));
        entityMetaRepository.delete(entityMeta);
    }

    private EntityMetaDTO convertToDTO(EntityMeta entityMeta) {
        EntityMetaDTO dto = new EntityMetaDTO();
        dto.setEntityMetaId(entityMeta.getEntityMetaId());
        dto.setName(entityMeta.getName());
        return dto;
    }

    private EntityMeta convertToEntity(EntityMetaDTO dto) {
        EntityMeta entityMeta = new EntityMeta();
        entityMeta.setEntityMetaId(dto.getEntityMetaId());
        entityMeta.setName(dto.getName());
        return entityMeta;
    }
}