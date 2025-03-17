package org.example.khanhshop.controler;


import org.example.khanhshop.dto.admin.request.AuthenticationRequest;
import org.example.khanhshop.dto.admin.response.AuthenticationResponse;
import org.example.khanhshop.service.authen.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tet/api")
public class AuthenControler {
    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
        return authenticationService.authenticate(authenticationRequest);
    }

}
