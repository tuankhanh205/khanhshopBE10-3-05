package org.example.khanhshop.dto.admin.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.khanhshop.entity.AttributeValue;
import org.example.khanhshop.entity.ProductImage;
import org.example.khanhshop.entity.Variant;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private Long categoryId;
    private String categoryName;
    private BigDecimal basePrice;
    private List<VariantRequest> variantRequests;
    private List<ProductImage> productImages;


}