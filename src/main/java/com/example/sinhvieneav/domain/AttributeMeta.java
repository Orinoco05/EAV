package com.example.sinhvieneav.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class AttributeMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeMetaId;
    private String name;
    private String datatype;

    @ManyToOne
    @JoinColumn(name = "entity_meta_id")
    private EntityMeta entityMeta;
}
