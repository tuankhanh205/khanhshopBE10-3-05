package org.example.khanhshop.service.admin.product;

import org.example.khanhshop.dto.admin.request.ProductRequest;
import org.example.khanhshop.dto.admin.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductItf {
     ProductResponse save(ProductRequest productRequest, List<MultipartFile> file) throws IOException;
     Page<ProductResponse> findAll(int page, int size);
     ProductResponse update(ProductRequest productRequest, List<MultipartFile> file,long id) throws IOException;
     ProductResponse getOne(long id);
     Page<ProductResponse> search(String name,int page,int size);
}
