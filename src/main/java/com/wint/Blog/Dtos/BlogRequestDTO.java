package com.wint.Blog.Dtos;

import jakarta.validation.constraints.NotNull;

public record BlogRequestDTO(@NotNull String name, @NotNull String description, @NotNull String content, @NotNull String date, @NotNull String image, @NotNull String user) {
}
