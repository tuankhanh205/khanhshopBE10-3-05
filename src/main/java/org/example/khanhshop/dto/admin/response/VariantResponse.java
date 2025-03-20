package org.example.khanhshop.dto.admin.response;

import java.math.BigDecimal;
import java.util.List;

public class VariantResponse {
    private Long id;

    private String sku;

    private BigDecimal price;

    private Integer stock;

    private String image;

    private List<VariantAttributeResponse> variantAttributeResponses;

    public VariantResponse() {
    }

    public VariantResponse(Long id, String sku, BigDecimal price, Integer stock, String image, List<VariantAttributeResponse> variantAttributeResponses) {
        this.id = id;
        this.sku = sku;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.variantAttributeResponses = variantAttributeResponses;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<VariantAttributeResponse> getVariantAttributeResponses() {
        return variantAttributeResponses;
    }

    public void setVariantAttributeResponses(List<VariantAttributeResponse> variantAttributeResponses) {
        this.variantAttributeResponses = variantAttributeResponses;
    }
}
