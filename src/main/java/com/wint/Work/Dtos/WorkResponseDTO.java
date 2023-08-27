package com.wint.Work.Dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record WorkResponseDTO(@NotNull UUID id, @NotNull String role, @NotNull String localization, @NotNull String startDate, @NotNull String endDate, @NotNull String[] tags, @NotNull String[] occupations, @NotNull String user) {
}
