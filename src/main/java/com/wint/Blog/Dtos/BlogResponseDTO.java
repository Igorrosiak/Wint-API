package com.wint.Blog.Dtos;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record BlogResponseDTO(
  @NotNull UUID id,
  @NotNull String name,
  @NotNull String description,
  @NotNull String content,
  @NotNull String date,
  @NotNull String image,
  @NotNull String user
) {}
