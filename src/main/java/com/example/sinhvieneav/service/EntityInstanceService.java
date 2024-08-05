package com.example.sinhvieneav.service;

import com.example.sinhvieneav.domain.EntityInstance;
import com.example.sinhvieneav.domain.EntityMeta;
import com.example.sinhvieneav.exception.ResourceNotFoundException;
import com.example.sinhvieneav.repository.EntityInstanceRepository;
import com.example.sinhvieneav.repository.EntityMetaRepository;
import com.example.sinhvieneav.service.dto.EntityInstanceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityInstanceService {
    private EntityInstanceRepository entityInstanceRepository;
    private EntityMetaRepository entityMetaRepository;

    public EntityInstanceService(EntityInstanceRepository entityInstanceRepository, EntityMetaRepository entityMetaRepository) {
        this.entityInstanceRepository = entityInstanceRepository;
        this.entityMetaRepository = entityMetaRepository;
    }

    public List<EntityInstanceDTO> getAllEntityInstances() {
        return entityInstanceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EntityInstance getEntityInstanceById(Long id) {
        return entityInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EntityInstance not found"));
    }

    public EntityInstanceDTO createEntityInstance(EntityInstanceDTO entityInstanceDTO) {
        EntityInstance entityInstance = new EntityInstance();
        EntityMeta entityMeta = entityMetaRepository.findById(entityInstanceDTO.getEntityMetaId())
                .orElseThrow(() -> new ResourceNotFoundException("EntityMeta not found"));
        entityInstance.setEntityMeta(entityMeta);
        entityInstance = entityInstanceRepository.save(entityInstance);
        return convertToDTO(entityInstance);
    }

    public EntityInstance saveEntityInstance(EntityInstance entityInstance) {
        return entityInstanceRepository.save(entityInstance);
    }

    public void deleteEntityInstance(Long id) {
        entityInstanceRepository.deleteById(id);
    }

    private EntityInstanceDTO convertToDTO(EntityInstance entityInstance) {
        EntityInstanceDTO dto = new EntityInstanceDTO();
        dto.setEntityInstanceId(entityInstance.getEntityInstanceId());
        dto.setEntityMetaId(entityInstance.getEntityMeta().getEntityMetaId());
        return dto;
    }
}