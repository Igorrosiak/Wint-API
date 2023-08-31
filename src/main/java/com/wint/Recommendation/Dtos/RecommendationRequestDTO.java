package com.wint.Recommendation.Dtos;

import jakarta.validation.constraints.NotNull;

public record RecommendationRequestDTO(
  @NotNull String description,
  @NotNull String relationship,
  @NotNull String recommendedUserId,
  @NotNull String idUserWhoRecommended
) {}
