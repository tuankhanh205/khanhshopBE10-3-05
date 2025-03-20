package org.example.khanhshop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    @Column(name = "created_at ")
    private LocalDateTime  createdAt;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttributeValue> values;

    @OneToMany(mappedBy = "attribute",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VariantAttribute> variantAttributes;
}
