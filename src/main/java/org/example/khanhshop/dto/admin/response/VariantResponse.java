package org.example.khanhshop.dto.admin.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VariantResponse {
    private Long id;

    private String sku;

    private BigDecimal price;

    private Integer stock;

    private String image;

    Map<String, String> attributes = new HashMap<>();

   private List<AttributeResponse> attributeResponses;

}
