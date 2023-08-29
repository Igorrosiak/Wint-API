package com.wint.User.Controllers;

import com.wint.User.Dtos.AuthenticationDTO;
import com.wint.User.Dtos.LoginResponseDTO;
import com.wint.User.Dtos.RegisterDTO;
import com.wint.User.Entitys.User;
import com.wint.User.Repositories.UserRepository;
import com.wint.User.Services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/login")
  public ResponseEntity login(
    @RequestBody @Valid AuthenticationDTO authenticationDTO
  ) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(
      authenticationDTO.email(),
      authenticationDTO.password()
    );
    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((User) auth.getPrincipal());
    return ResponseEntity.ok(new LoginResponseDTO(token));
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
    if (this.userRepository.findByEmail(registerDTO.email()) != null) {
      return ResponseEntity.badRequest().build();
    }

    String encryptedPassword = new BCryptPasswordEncoder()
      .encode(registerDTO.password());
    User newUser = new User();
    BeanUtils.copyProperties(registerDTO, newUser);
    this.userRepository.save(newUser);
    return ResponseEntity.ok().build();
  }
}
