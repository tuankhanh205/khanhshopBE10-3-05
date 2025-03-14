package org.example.khanhshop.service.admin.product;

import org.example.khanhshop.dto.request.ProductRequest;
import org.example.khanhshop.dto.response.ProductResponse;
import org.example.khanhshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductItf {
     ProductResponse save(ProductRequest productRequest, List<MultipartFile> file) throws IOException;
     Page<ProductResponse> findAll(int page, int size);
}
