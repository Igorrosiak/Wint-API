package com.wint.User.Services;

import com.wint.User.Dtos.AuthenticationRequestDTO;
import com.wint.User.Dtos.AuthenticationResponseDTO;
import com.wint.User.Entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity<AuthenticationResponseDTO> login(AuthenticationRequestDTO authenticationRequestDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationRequestDTO.email(),
                authenticationRequestDTO.password()
        );
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new AuthenticationResponseDTO(token));
    }
}
