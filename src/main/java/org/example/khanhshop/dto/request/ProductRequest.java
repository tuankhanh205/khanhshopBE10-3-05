package org.example.khanhshop.dto.request;

import org.example.khanhshop.entity.ProductDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductRequest {

    private String name;


    private String description;



    private String image;

    private Long brandId;

    private Long categoryId;

    private List<ProductDetailRequest> productDetails;

    public ProductRequest() {
    }

    public ProductRequest(String name, String description, String image, Long brandId, Long categoryId, List<ProductDetailRequest> productDetails) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.productDetails = productDetails;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<ProductDetailRequest> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailRequest> productDetails) {
        this.productDetails = productDetails;
    }
}
