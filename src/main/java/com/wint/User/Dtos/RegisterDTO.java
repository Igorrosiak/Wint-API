package com.wint.User.Dtos;

import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull String name, @NotNull String email, @NotNull String password, @NotNull String birthDate) {
}
