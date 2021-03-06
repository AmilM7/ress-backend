package com.ressbackend.controllers;


import com.ressbackend.models.dtos.AuthenticationRequestPayload;
import com.ressbackend.models.dtos.AuthenticationResponsePayload;
import com.ressbackend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponsePayload> createAuthenticationToken(
            @RequestBody AuthenticationRequestPayload payload
    ) {
        UsernamePasswordAuthenticationToken userAutenticator = new UsernamePasswordAuthenticationToken(payload.getEmail(), payload.getPassword());
        try {
            authenticationManager.authenticate(userAutenticator);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new RuntimeException("Error authenticating!");
        }

        final String jwt = jwtTokenUtil.generateToken(payload.getEmail());

        return ResponseEntity.ok(new AuthenticationResponsePayload(jwt));
    }

}
