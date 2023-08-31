package com.wint.Recommendation.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "recommendations")
@Entity(name = "recommendations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull
  private String description;

  @NotNull
  private String relationship;

  @NotNull
  private String recommendedUserId;

  @NotNull
  private String idUserWhoRecommended;
}
