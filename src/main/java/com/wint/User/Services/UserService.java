package com.wint.User.Services;

import com.wint.User.Entitys.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface UserService {
  public ResponseEntity<List<User>> findAll();

  public ResponseEntity<Optional<User>> findById(UUID id);

  public ResponseEntity<User> create(User user);

  public ResponseEntity<User> update(UUID id, User user);

  public ResponseEntity delete(UUID id);
}
