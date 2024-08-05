package com.example.sinhvieneav.controller;

import com.example.sinhvieneav.domain.AttributeMeta;
import com.example.sinhvieneav.service.AttributeMetaService;
import com.example.sinhvieneav.service.dto.AttributeMetaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute-meta")
public class AttributeMetaController {
    private final AttributeMetaService attributeMetaService;

    public AttributeMetaController(AttributeMetaService attributeMetaService) {
        this.attributeMetaService = attributeMetaService;
    }

    @GetMapping
    public List<AttributeMetaDTO> getAllAttributeMetas() {
        return attributeMetaService.getAllAttributeMetas();
    }

    @GetMapping("/{id}")
    public AttributeMetaDTO getAttributeMetaById(@PathVariable Long id) {
        return attributeMetaService.getAttributeMetaById(id);
    }

    @PostMapping
    public AttributeMetaDTO createAttributeMeta(@RequestBody AttributeMetaDTO attributeMetaDTO) {
        AttributeMetaDTO createdAttributeMeta = attributeMetaService.createAttributeMeta(attributeMetaDTO);
        return createdAttributeMeta;
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeMetaDTO> updateAttributeMeta(@PathVariable Long id, @RequestBody AttributeMetaDTO attributeMetaDTO) {
        AttributeMetaDTO updatedAttributeMeta = attributeMetaService.updateAttributeMeta(id, attributeMetaDTO);
        return ResponseEntity.ok(updatedAttributeMeta);
    }

    @DeleteMapping("/{id}")
    public void deleteAttributeMeta(@PathVariable Long id) {
        attributeMetaService.deleteAttributeMeta(id);
    }
}