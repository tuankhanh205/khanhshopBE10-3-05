package org.example.khanhshop.controler.admin.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.khanhshop.dto.admin.request.ProductRequest;
import org.example.khanhshop.dto.admin.response.ProductResponse;
import org.example.khanhshop.service.admin.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class ProductCon {
    @Autowired
    private ProductService productService;
    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<ProductResponse> save(
            @RequestPart("productRequest") String productRequestJson,  // Nhận JSON dưới dạng String
            @RequestPart("productFiles") List<MultipartFile> productFiles,
            @RequestPart(value = "variantFiles", required = false) MultipartFile variantFile) throws IOException {

        // Chuyển JSON từ String -> Object
        ObjectMapper objectMapper = new ObjectMapper();
        ProductRequest productRequest = objectMapper.readValue(productRequestJson, ProductRequest.class);

        return ResponseEntity.ok(productService.save(productRequest, productFiles, variantFile));
    }
    @GetMapping("/getall")
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }


}
