package org.example.khanhshop.dto.admin.response;

public class ColorResponse {
    private Long id;
    private String colorName;

    public ColorResponse() {
    }

    public ColorResponse(Long id, String colorName) {
        this.id = id;
        this.colorName = colorName;
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
}
