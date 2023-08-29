package com.wint.Recommendation.Dtos;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record RecommendationResponseDTO(
  @NotNull UUID id,
  @NotNull String description,
  @NotNull String relationship,
  @NotNull String recommendedUser,
  @NotNull String userWhoRecommended
) {}
