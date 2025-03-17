package org.example.khanhshop.service.admin.productdetail;

import org.example.khanhshop.dto.admin.response.ProductDetailResponse;
import org.example.khanhshop.entity.ProductDetail;
import org.example.khanhshop.repository.admin.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDetailService implements ProductDetailItf{

    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Override
    public List<ProductDetailResponse> findByProductDetail(Long id) {
        List<ProductDetail> productDetails=productDetailRepository.getProductDetailById(id);
        return productDetails.stream().map(productDetail -> mapToProductDetail(productDetail)).collect(Collectors.toUnmodifiableList());
    }

    public ProductDetailResponse mapToProductDetail(ProductDetail productDetail){
        ProductDetailResponse productDetailResponse=new ProductDetailResponse();
        productDetailResponse.setId(productDetail.getId());
        productDetailResponse.setStatus(productDetail.getStatus().name());
        productDetailResponse.setPrice(productDetail.getPrice());
        productDetailResponse.setStock(productDetail.getStock());
        productDetailResponse.setColorName(productDetail.getColor().getName());
        productDetailResponse.setSizeName(productDetail.getSize().getName());
       return productDetailResponse;

    }
}
