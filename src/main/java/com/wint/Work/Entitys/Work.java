package com.wint.Work.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "works")
@Entity(name = "works")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Work {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull
  private String role;

  @NotNull
  private String localization;

  @NotNull
  private String startDate;

  @NotNull
  private String endDate;

  @NotNull
  private String[] tags;

  @NotNull
  private String[] occupations;

  @NotNull
  private String userId;
}
