package com.example.sinhvieneav.controller;

import com.example.sinhvieneav.domain.EntityInstance;
import com.example.sinhvieneav.service.EntityInstanceService;
import com.example.sinhvieneav.service.dto.EntityInstanceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/entity-instance")
public class EntityInstanceController {
    private EntityInstanceService entityInstanceService;

    public EntityInstanceController(EntityInstanceService entityInstanceService) {
        this.entityInstanceService = entityInstanceService;
    }

    @GetMapping
    public List<EntityInstanceDTO> getAllEntityInstances() {
        return entityInstanceService.getAllEntityInstances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityInstance> getEntityInstanceById(@PathVariable Long id) {
        EntityInstance entityInstance = entityInstanceService.getEntityInstanceById(id);
        return ResponseEntity.ok(entityInstance);
    }

    @PostMapping
    public ResponseEntity<EntityInstanceDTO> createEntityInstance(@RequestBody EntityInstanceDTO entityInstanceDTO) {
        EntityInstanceDTO createdEntityInstance = entityInstanceService.createEntityInstance(entityInstanceDTO);
        return ResponseEntity.ok(createdEntityInstance);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityInstance(@PathVariable Long id) {
        entityInstanceService.deleteEntityInstance(id);
    }
}