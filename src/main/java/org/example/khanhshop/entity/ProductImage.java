package org.example.khanhshop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "product_image")
@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url",columnDefinition = "Text")
    private String imageUrl;

    @Column(name="is_thumbnail")
    private boolean isThumbnail=false;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer position = 0;

    @Column(name = "created_at ")
    private LocalDateTime createdAt ;

    @OneToMany(mappedBy = "productImage")
    private List<Variant> variants;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}

