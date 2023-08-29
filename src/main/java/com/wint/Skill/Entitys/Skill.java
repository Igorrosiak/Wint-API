package com.wint.Skill.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "skills")
@Entity(name = "skill")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Getter
  @NotNull
  private String name;

  @Getter
  @NotNull
  private String description;

  @Getter
  @NotNull
  private String icon;

  @Getter
  @NotNull
  // Make User model and modify this
  private String userId;
}
