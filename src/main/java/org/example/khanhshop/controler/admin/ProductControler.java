package org.example.khanhshop.controler.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.khanhshop.dto.request.ProductRequest;
import org.example.khanhshop.dto.response.ProductResponse;
import org.example.khanhshop.service.admin.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/tet")
public class ProductControler {
    @Autowired
    private ProductService productService;
    @PostMapping(value = "/save/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> save(
            @RequestPart("productRequest") String productRequestJson, // Nhận JSON dưới dạng String
            @RequestPart(value = "file", required = false) List<MultipartFile> files) throws Exception {

        // Chuyển đổi JSON String thành ProductRequest object
        ObjectMapper objectMapper = new ObjectMapper();
        ProductRequest productRequest = objectMapper.readValue(productRequestJson, ProductRequest.class);

        return ResponseEntity.ok(productService.save(productRequest, files));

    }


    @GetMapping("/product")
    ResponseEntity<Page<ProductResponse>> findAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(productService.findAll(page, size));
    }


}
