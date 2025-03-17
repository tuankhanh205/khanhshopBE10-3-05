package org.example.khanhshop.controler.admin;

import org.example.khanhshop.dto.admin.response.SizeResponse;
import org.example.khanhshop.service.admin.size.SizeService;
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
public class SizeControler {

    @Autowired
    private SizeService sizeService;
    @GetMapping("/size")
    public ResponseEntity<List<SizeResponse>> getAll(){
        return ResponseEntity.ok(sizeService.getAll());
    }
}
