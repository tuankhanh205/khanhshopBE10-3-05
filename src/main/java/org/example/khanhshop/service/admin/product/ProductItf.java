package org.example.khanhshop.service.admin.product;

import org.example.khanhshop.dto.admin.request.ProductRequest;
import org.example.khanhshop.dto.admin.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductItf {
    ProductResponse save(ProductRequest productRequest, MultipartFile file);
}
