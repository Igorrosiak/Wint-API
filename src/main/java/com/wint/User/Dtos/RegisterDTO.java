package com.wint.User.Dtos;

import com.wint.User.Entitys.UserRoleENUM;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
  @NotNull String name,
  @NotNull String username,
  @NotNull String email,
  @NotNull String password,
  @NotNull String birthDate,
  @NotNull UserRoleENUM role
) {}
