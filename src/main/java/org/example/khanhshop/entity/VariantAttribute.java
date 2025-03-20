package org.example.khanhshop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "variant_attributes")
public class VariantAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at ",updatable = false)
    private LocalDateTime  createdAt;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = "attribute_value_id", nullable = false)
    private AttributeValue attributeValue;

    public VariantAttribute() {
    }

    public VariantAttribute(Long id, LocalDateTime createdAt, Variant variant, Attribute attribute, AttributeValue attributeValue) {
        this.id = id;
        this.createdAt = createdAt;
        this.variant = variant;
        this.attribute = attribute;
        this.attributeValue = attributeValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public AttributeValue getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
    }
}
