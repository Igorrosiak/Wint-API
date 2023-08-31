package com.wint.Blog.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "blogs")
@Entity(name = "blogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private String content;

  @NotNull
  private String date;

  private String image;

  @NotNull
  private String userId;
}
