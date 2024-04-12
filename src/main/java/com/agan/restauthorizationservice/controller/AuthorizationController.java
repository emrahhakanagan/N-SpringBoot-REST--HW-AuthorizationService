package com.agan.restauthorizationservice.controller;

import com.agan.restauthorizationservice.enums.Authorities;
import com.agan.restauthorizationservice.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @GetMapping("/authorize")
    public ResponseEntity<List<Authorities>> getAuthorities(
            @Validated @RequestParam("user") String user, @Validated @RequestParam("password") String password) {

        List<Authorities> authorities = authorizationService.getAuthorities(user, password);
        return ResponseEntity.ok(authorities);
    }
}