package com.wint.Curriculum.Entitys;

import com.wint.User.Entitys.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "curriculums")
@Entity(name = "curriculums")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull
  private String name;

  @NotNull
  private String tag;

  @NotNull
  private String image;

  @NotNull
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
}
