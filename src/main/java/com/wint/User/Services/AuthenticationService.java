package com.wint.User.Services;

import com.wint.User.Dtos.AuthenticationRequestDTO;
import com.wint.User.Dtos.AuthenticationResponseDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    public ResponseEntity<AuthenticationResponseDTO> login(AuthenticationRequestDTO authenticationRequestDTO);
}
