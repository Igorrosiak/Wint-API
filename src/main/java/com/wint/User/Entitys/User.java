package com.wint.User.Entitys;

import com.wint.Blog.Entitys.Blog;
import com.wint.Curriculum.Entitys.Curriculum;
import com.wint.Recommendation.Entitys.Recommendation;
import com.wint.Skill.Entitys.Skill;
import com.wint.Work.Entitys.Work;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "users")
@Entity(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
  @Id
  @Setter
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Setter
  @NotNull
  private String name;

  @Setter
  @NotNull
  @Column(unique = true)
  private String username;

  @Setter
  @NotNull
  @Column(unique = true)
  private String email;

  @Setter
  @NotNull
  private String password;

  @Setter
  @NotNull
  private String birthDate;

  @Setter
  @NotNull
  private UserRoleENUM role;

  @Setter
  private String presentation;

  @Setter
  private String githubLink;

  @Setter
  private String linkedinLink;

  @Setter
  private String instagramLink;

  @Setter
  private String facebookLink;

  @Setter
  private String twitterLink;

  @OneToMany(mappedBy = "user")
  private List<Blog> blogs;

  @OneToMany(mappedBy = "user")
  private List<Curriculum> curriculums;

  @OneToMany(mappedBy = "user")
  private List<Recommendation> recommendations;

  @OneToMany(mappedBy = "user")
  private List<Skill> skills;

  @OneToMany(mappedBy = "user")
  private List<Work> works;

  public User(String name, String username, String email, String password, String birthDate, UserRoleENUM role){
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.birthDate = birthDate;
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
