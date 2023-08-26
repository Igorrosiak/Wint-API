package com.wint.Curriculum.Dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CurriculumResponseDTO(@NotNull UUID id, @NotNull String name, @NotNull String tag, @NotNull String image, @NotNull String user) {
}
