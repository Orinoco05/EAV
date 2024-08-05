package com.example.sinhvieneav.controller;

import com.example.sinhvieneav.service.EntityAttributeValueService;
import com.example.sinhvieneav.service.dto.EntityAttributeValueDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entity-attribute-value")
public class EntityAttributeValueController {

    private final EntityAttributeValueService entityAttributeValueService;

    @GetMapping
    public List<EntityAttributeValueDTO> getAllEntityAttributeValues() {
        return entityAttributeValueService.getAllEntityAttributeValueDTOs();
    }

    @GetMapping("/{id}")
    public EntityAttributeValueDTO getEntityAttributeValueById(@PathVariable Long id) {
        return entityAttributeValueService.getEntityAttributeValueById(id);
    }

    @PostMapping
    public EntityAttributeValueDTO createEntityAttributeValue(@RequestBody EntityAttributeValueDTO entityAttributeValueDTO) {
        return entityAttributeValueService.saveEntityAttributeValue(entityAttributeValueDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityAttributeValue(@PathVariable Long id) {
        entityAttributeValueService.deleteEntityAttributeValue(id);
    }
}
