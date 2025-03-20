package org.example.khanhshop.dto.admin.response;

public class VariantAttributeResponse {
    private String attributeName;

    private String attributeValue;

    public VariantAttributeResponse() {
    }

    public VariantAttributeResponse(String attributeName, String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
