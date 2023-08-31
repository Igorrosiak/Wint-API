package com.wint.Work.Dtos;

import jakarta.validation.constraints.NotNull;

public record WorkRequestDTO(
  @NotNull String role,
  @NotNull String localization,
  @NotNull String startDate,
  @NotNull String endDate,
  @NotNull String[] tags,
  @NotNull String[] occupations,
  @NotNull String userId
) {}
