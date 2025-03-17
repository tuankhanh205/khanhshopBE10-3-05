package org.example.khanhshop.service.admin.productdetail;

import org.example.khanhshop.dto.admin.response.ProductDetailResponse;

import java.util.List;

public interface ProductDetailItf {
    List<ProductDetailResponse> findByProductDetail(Long id);

}
