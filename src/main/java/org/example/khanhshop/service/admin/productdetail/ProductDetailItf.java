package org.example.khanhshop.service.admin.productdetail;

import org.example.khanhshop.dto.response.ProductDetailResponse;

import java.util.List;

public interface ProductDetailItf {
    List<ProductDetailResponse> findByProductDetail(Long id);

}
