package org.example.khanhshop.controler.admin;

import org.example.khanhshop.dto.admin.response.BrandResponse;
import org.example.khanhshop.service.admin.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tet")
@CrossOrigin(origins = "http://localhost:5174")
public class BrandControler {
    @Autowired
    private BrandService brandService;
    @GetMapping("/brand")
    public ResponseEntity<List<BrandResponse>> getAll(){
        return ResponseEntity.ok(brandService.getAll());
    }

}
