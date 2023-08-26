package com.wint.User.Dtos;

import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(@NotNull String name, @NotNull String email, @NotNull String password, @NotNull String birthDate, String presentation, String githubLink, String linkedinLink, String instagramLink, String facebookLink, String twitterLink, @NotNull String user) {
}
