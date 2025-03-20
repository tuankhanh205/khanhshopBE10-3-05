package org.example.khanhshop.dto.admin.request;

import java.math.BigDecimal;
import java.util.List;

public class VariantRequest {
    private String sku;

    private int productId;

    private BigDecimal price;

    private int stock;

    private int imageId;

    private List<VariantAttributeRequest> variantAttributeRequests;
}
