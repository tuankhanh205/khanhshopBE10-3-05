package org.example.khanhshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "variants")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(precision = 10,scale = 2)
    private BigDecimal price;



    private int stock;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private VariantImage variantImage;

    @JsonIgnore
    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VariantAttribute> attributes=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "product_image_id")
    private ProductImage productImage;

    @JsonIgnore
    @OneToMany(mappedBy = "variant")
    private List<CartItem> cartItems=new ArrayList<>();

    public Variant() {
    }

    public Variant(Long id, String sku, Product product, BigDecimal price, int stock, LocalDateTime createdAt, LocalDateTime updatedAt, VariantImage variantImage, List<VariantAttribute> attributes, ProductImage productImage, List<CartItem> cartItems) {
        this.id = id;
        this.sku = sku;
        this.product = product;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.variantImage = variantImage;
        this.attributes = attributes;
        this.productImage = productImage;
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public VariantImage getVariantImage() {
        return variantImage;
    }

    public void setVariantImage(VariantImage variantImage) {
        this.variantImage = variantImage;
    }

    public List<VariantAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<VariantAttribute> attributes) {
        this.attributes = attributes;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
