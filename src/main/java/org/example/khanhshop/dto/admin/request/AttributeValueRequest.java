package org.example.khanhshop.dto.admin.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValueRequest {
    private Long attributeId;
    private Long attribute_value_id;
}
