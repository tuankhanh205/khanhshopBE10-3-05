package org.example.khanhshop.controler.admin;

import org.example.khanhshop.dto.admin.response.ProductDetailResponse;
import org.example.khanhshop.service.admin.productdetail.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tet")
@CrossOrigin(origins = "http://localhost:5174")
public class ProductDetailControler {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/producdetail/{id}")
    public ResponseEntity<List<ProductDetailResponse>> findByProductDetail(@PathVariable("id") Long id){
        return ResponseEntity.ok(productDetailService.findByProductDetail(id));
    }
}
