package org.example.khanhshop.controler.admin;

import org.example.khanhshop.dto.admin.response.CategoryResponse;
import org.example.khanhshop.service.admin.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tet")
@CrossOrigin(origins = "http://localhost:5174")
public class CategoryControler {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity<Page<CategoryResponse> >findAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "4") int size){
        Page<CategoryResponse> categories = categoryService.findAll(page, size);
        return ResponseEntity.ok(categories);    }


}
