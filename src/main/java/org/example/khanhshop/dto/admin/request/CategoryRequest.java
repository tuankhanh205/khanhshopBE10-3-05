package org.example.khanhshop.dto.admin.request;

import jakarta.persistence.Column;

public class CategoryRequest {


    private String name;


    private String description;

    public CategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryRequest() {
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
}
