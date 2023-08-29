package com.wint.Blog.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "blogs")
@Entity(name = "blog")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

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
  private String content;

  @Getter
  @NotNull
  private String date;

  @Getter
  private String image;

  @Getter
  @NotNull
  // Make User model and modify this
  private String userId;
}
