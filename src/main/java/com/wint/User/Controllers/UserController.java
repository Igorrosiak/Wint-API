package com.wint.User.Controllers;

import com.wint.User.Entitys.User;
import com.wint.User.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("s")
    public ResponseEntity<List<User>> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable UUID id){
        return userService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody @Valid UserRequestDTO userRequestDTO){
        var user = new User();
        BeanUtils.copyProperties(userRequestDTO, user);
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody @Valid UserRequestDTO userRequestDTO){
        var user = new User();
        BeanUtils.copyProperties(userRequestDTO, user);
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return userService.delete(id);
    }
}
