package com.wint.User.Controllers;

import com.wint.User.Dtos.AuthenticationRequestDTO;
import com.wint.User.Dtos.AuthenticationResponseDTO;
import com.wint.User.Entitys.User;
import com.wint.User.Services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  TokenService tokenService;

  @PostMapping("/")
  public ResponseEntity login(
    @RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO
  ) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(
      authenticationRequestDTO.email(),
      authenticationRequestDTO.password()
    );
    var auth = authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((User) auth.getPrincipal());
    return ResponseEntity.ok(new AuthenticationResponseDTO(token));
  }
}
