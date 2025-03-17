package org.example.khanhshop.dto.admin.response;

public class SizeResponse {
    private Long id;

    private String sizeName;

    public SizeResponse() {
    }

    public SizeResponse(Long id, String sizeName) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
}
