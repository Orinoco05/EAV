package com.example.sinhvieneav.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class EntityMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityMetaId;
    private String name;
    @OneToMany(mappedBy = "entityMeta", cascade = CascadeType.ALL)
    private List<AttributeMeta> attributes;
}
