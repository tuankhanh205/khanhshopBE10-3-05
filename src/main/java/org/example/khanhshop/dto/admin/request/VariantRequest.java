package org.example.khanhshop.dto.admin.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VariantRequest {
    private Long id;
    private String sku;

    private Long productId;

    private BigDecimal price;

    private Integer stock;

    private Long imageId;

    private List<VariantAttributeRequest> variantAttributeRequests;


}
