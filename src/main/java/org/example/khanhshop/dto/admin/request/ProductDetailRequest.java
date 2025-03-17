package org.example.khanhshop.dto.admin.request;

import java.math.BigDecimal;

public class ProductDetailRequest {
    private Long colorId;
    private Long sizeId;
    private BigDecimal price;
    private Integer stock;

    public ProductDetailRequest() {
    }

    public ProductDetailRequest(Long colorId, Long sizeId, BigDecimal price, Integer stock) {
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.price = price;
        this.stock = stock;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
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
}
