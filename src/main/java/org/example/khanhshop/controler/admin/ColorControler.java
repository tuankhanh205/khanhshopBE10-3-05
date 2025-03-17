package org.example.khanhshop.controler.admin;

import org.example.khanhshop.dto.admin.response.ColorResponse;
import org.example.khanhshop.service.admin.color.ColorService;
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
public class ColorControler {
    @Autowired
    private ColorService colorService;
    @GetMapping("/color")
    public ResponseEntity<List<ColorResponse>> getAll(){
        return ResponseEntity.ok(colorService.getAll());
    }
}
