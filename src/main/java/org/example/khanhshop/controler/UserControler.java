package org.example.khanhshop.controler;


import org.example.khanhshop.entity.User;
import org.example.khanhshop.service.Uservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControler {
    @Autowired
    private Uservice uservice;
    @PostMapping
    public User createMK(@RequestBody User user){
        return uservice.createMK(user);
    }
}
