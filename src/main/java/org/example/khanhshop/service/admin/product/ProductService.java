package org.example.khanhshop.service.admin.product;

import org.example.khanhshop.dto.admin.request.ProductRequest;
import org.example.khanhshop.dto.admin.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService implements ProductItf{
    @Override
    public ProductResponse save(ProductRequest productRequest, MultipartFile file) {
        return null;
    }
}
