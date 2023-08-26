package com.wint.Curriculum.Dtos;

import jakarta.validation.constraints.NotNull;

public record CurriculumRequestDTO(@NotNull String name, @NotNull String tag, @NotNull String image, @NotNull String user) {
}
