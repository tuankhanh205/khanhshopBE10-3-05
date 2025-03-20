package org.example.khanhshop.dto.admin.request;

public class VariantAttributeRequest {
    private int variantId;
    private int attributeId;
    private int attributeValue;

    public VariantAttributeRequest() {
    }

    public VariantAttributeRequest(int variantId, int attributeId, int attributeValue) {
        this.variantId = variantId;
        this.attributeId = attributeId;
        this.attributeValue = attributeValue;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public int getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(int attributeValue) {
        this.attributeValue = attributeValue;
    }
}

