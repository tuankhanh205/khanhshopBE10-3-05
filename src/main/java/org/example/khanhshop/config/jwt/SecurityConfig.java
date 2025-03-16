package org.example.khanhshop.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] PUBLIC_ENDPOINTS = {"/user/tet", "/tet/api/login"};
    private static final String[] ADMIN_ENDPOINTS = {"/tet"};

    @Value("${jwt.signer_key}")
    private String signerKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()

//                        .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS).permitAll()
//                        .requestMatchers(HttpMethod.GET, ADMIN_ENDPOINTS).hasAuthority("SCOPE_ROLE_ADMIN")
//                        .anyRequest().authenticated()
                );
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder())))
//                .csrf(csrf -> csrf.disable()); // Tắt CSRF nếu không dùng session


        return http.build();
    }

    @Bean
    JwtDecoder jwtDecoder(){
        SecretKeySpec secretKeySpec=new SecretKeySpec(signerKey.getBytes(),"HS512");
        return NimbusJwtDecoder.withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }
}
