package com.wint.User.Services;

import com.wint.User.Entitys.User;
import com.wint.User.Repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public ResponseEntity<List<User>> findAll() {
    try {
      List<User> usersList = userRepository.findAll();
      if (usersList.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(usersList);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Optional<User>> findById(UUID id) {
    try {
      Optional<User> userOptional = userRepository.findById(id);
      if (userOptional.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(userOptional);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<User> create(User user) {
    try {
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(userRepository.save(user));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @Override
  public ResponseEntity<User> update(UUID id, User user) {
    try {
      Optional<User> userOptional = userRepository.findById(id);
      if (userOptional.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(userRepository.save(user));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Object> delete(UUID id) {
    try {
      Optional<User> userOptional = userRepository.findById(id);
      if (userOptional.isEmpty()) {
        return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("User not found");
      }
      userRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK).body("User was Deleted");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
