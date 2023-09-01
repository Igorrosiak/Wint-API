package com.wint.User.Controllers;

import com.wint.User.Dtos.RegisterDTO;
import com.wint.User.Dtos.UserRequestDTO;
import com.wint.User.Entitys.User;
import com.wint.User.Services.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public ResponseEntity<List<User>> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<User>> findById(@PathVariable UUID id) {
    return userService.findById(id);
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<Optional<User>> findById(@PathVariable String username) {
    return userService.findByUsername(username);
  }

  @PostMapping("/")
  public ResponseEntity<User> create(@RequestBody @Valid RegisterDTO registerDTO) {
    return userService.create(registerDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(
    @PathVariable UUID id,
    @RequestBody @Valid UserRequestDTO userRequestDTO
  ) {
    var user = new User();
    BeanUtils.copyProperties(userRequestDTO, user);
    return userService.update(id, user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable UUID id) {
    return userService.delete(id);
  }
}
