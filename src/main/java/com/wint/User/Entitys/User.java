package com.wint.User.Entitys;

import com.wint.Skill.Entitys.Skill;
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
@Setter
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
  private List<Skill> skills;

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
