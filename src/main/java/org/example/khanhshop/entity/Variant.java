package org.example.khanhshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "variants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private int stock;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "variant", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private VariantImage variantImage;

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL, orphanRemoval = true,fetch =  FetchType.EAGER)
    private List<VariantAttribute> attributes = new ArrayList<>();

    @OneToMany(mappedBy = "variant",fetch = FetchType.EAGER)
    private List<ProductImage> productImages=new ArrayList<>();
}
