package com.wint.User.Dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserResponseDTO(@NotNull UUID id, @NotNull String name, @NotNull String email, @NotNull String password, @NotNull String birthDate, String presentation, String githubLink, String linkedinLink, String instagramLink, String facebookLink, String twitterLink, @NotNull String user) {
}
