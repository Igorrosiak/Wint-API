package com.wint.Recommendation.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "recommendations")
@Entity(name = "recommendation")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Getter
  @NotNull
  private String description;

  @Getter
  @NotNull
  private String relationship;

  @Getter
  @NotNull
  // Make User model and modify this
  private String recommendedUserId;

  @Getter
  @NotNull
  // Make User model and modify this
  private String userWhoRecommendedId;
}
