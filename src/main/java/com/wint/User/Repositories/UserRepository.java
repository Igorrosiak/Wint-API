package com.wint.User.Repositories;

import com.wint.User.Entitys.User;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  UserDetails findByEmail(String email);
  Optional<User> findByUsername(String username);
}
