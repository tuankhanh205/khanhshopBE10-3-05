package org.example.khanhshop.dto.admin.response;

import java.math.BigDecimal;

public class ProductDetailResponse {
    private Long id;
    private String colorName;
    private String sizeName;
    private BigDecimal price;
    private Integer stock;
    private String status;

    public ProductDetailResponse() {
    }

    public ProductDetailResponse(Long id, String colorName, String sizeName, BigDecimal price, Integer stock, String status) {
        this.id = id;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
