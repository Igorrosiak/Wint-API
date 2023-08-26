package com.wint.Work.Dtos;

import jakarta.validation.constraints.NotNull;

public record WorkRequestDTO(@NotNull String role, @NotNull String localization, @NotNull String startDate, @NotNull String endDate, @NotNull Array<String> tags, @NotNull Array<String> occupations, @NotNull String user) {
}
