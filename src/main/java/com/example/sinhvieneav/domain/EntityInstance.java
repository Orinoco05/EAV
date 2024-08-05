package com.example.sinhvieneav.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class EntityInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityInstanceId;

    @ManyToOne
    @JoinColumn(name = "entity_meta_id")
    private EntityMeta entityMeta;

    @OneToMany(mappedBy = "entityInstance", cascade = CascadeType.ALL)
    private List<EntityAttributeValue> values;
    public Long getEntityInstanceId() {
        return entityInstanceId;
    }
}
