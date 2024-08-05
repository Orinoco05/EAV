package com.example.sinhvieneav.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EntityAttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityAttributeValueId;

    @ManyToOne
    @JoinColumn(name = "entity_instance_id")
    private EntityInstance entityInstance;

    @ManyToOne
    @JoinColumn(name = "attribute_meta_id")
    private AttributeMeta attributeMeta;

    private String value;

    @Column(name = "datatype")
    private String dataType;
}
