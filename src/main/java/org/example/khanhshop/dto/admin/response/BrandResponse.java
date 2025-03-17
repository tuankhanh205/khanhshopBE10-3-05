package org.example.khanhshop.dto.admin.response;

public class BrandResponse {
    private Long id;
    private String brandName;

    public BrandResponse() {
    }

    public BrandResponse(Long id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
