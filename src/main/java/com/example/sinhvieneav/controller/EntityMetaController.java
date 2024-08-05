package com.example.sinhvieneav.controller;

import com.example.sinhvieneav.service.EntityMetaService;
import com.example.sinhvieneav.service.dto.EntityMetaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entity-meta")
public class EntityMetaController {
    private EntityMetaService entityMetaService;

    public EntityMetaController(EntityMetaService entityMetaService) {
        this.entityMetaService = entityMetaService;
    }

    @GetMapping
    public List<EntityMetaDTO> getAllEntityMetas() {
        return entityMetaService.getAllEntityMetas();
    }

    @GetMapping("/{id}")
    public EntityMetaDTO getEntityMetaById(@PathVariable Long id) {
        return entityMetaService.getEntityMetaById(id);
    }

    @PostMapping
    public EntityMetaDTO createEntityMeta(@RequestBody EntityMetaDTO entityMetaDTO) {
        return entityMetaService.saveEntityMeta(entityMetaDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EntityMetaDTO> updateEntityMeta(@PathVariable Long id, @RequestBody EntityMetaDTO entityMetaDTO) {
        EntityMetaDTO updatedEntityMeta = entityMetaService.updateEntityMeta(id, entityMetaDTO);
        return ResponseEntity.ok(updatedEntityMeta);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntityMeta(@PathVariable Long id) {
        entityMetaService.deleteEntityMeta(id);
        return ResponseEntity.noContent().build();
    }

}
