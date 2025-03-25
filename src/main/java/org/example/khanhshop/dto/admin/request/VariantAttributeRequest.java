package org.example.khanhshop.dto.admin.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VariantAttributeRequest {
    private Long variantId;
    private Long attributeId;
    private List<Long> attributeValueIds;
    private List<String> newAttributeValueRequest;
}
