package org.example.khanhshop.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Tet {
    @GetMapping("/tet")
    public String tet(){
        return "Hello World";
    }
}
