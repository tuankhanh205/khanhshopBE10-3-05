package org.example.khanhshop.service.admin.product;

import org.example.khanhshop.dto.admin.request.ProductRequest;
import org.example.khanhshop.dto.admin.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface ProductItf {
    List<ProductResponse> getAllProducts();
    ProductResponse save(ProductRequest productRequest, List<MultipartFile> productFiles, MultipartFile variantImage) throws IOException;
}