package com.wint.User.Services;

import com.wint.User.Dtos.RegisterDTO;
import com.wint.User.Entitys.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface UserService {
  public ResponseEntity<List<User>> findAll();

  public ResponseEntity<Optional<User>> findById(UUID id);

  public ResponseEntity<Optional<User>> findByUsername(String username);

  public ResponseEntity<User> create(RegisterDTO registerDTO);

  public ResponseEntity<User> update(UUID id, User user);

  public ResponseEntity delete(UUID id);
}
