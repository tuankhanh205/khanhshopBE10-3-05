package org.example.khanhshop.dto.admin.response;

import java.time.LocalDateTime;
import java.util.List;

public class ProductResponse {
    private Long id;

    private String name;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String categoryName;
    private String status;
    private Long stock;

    private List<ProductDetailResponse> productDetails;

    private List<String> images;



    public ProductResponse() {
    }

    public ProductResponse(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String categoryName, String status, Long stock, List<ProductDetailResponse> productDetails, List<String> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.categoryName = categoryName;
        this.status = status;
        this.stock = stock;
        this.productDetails = productDetails;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public List<ProductDetailResponse> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailResponse> productDetails) {
        this.productDetails = productDetails;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
