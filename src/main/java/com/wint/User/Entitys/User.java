package com.wint.User.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "user")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @NotNull
    private String name;

    @Getter
    @NotNull
    @Column(unique = true)
    private String email;

    @Getter
    @NotNull
    private String password;

    @Getter
    @NotNull
    private String birthDate;

    @Getter
    private String presentation;

    @Getter
    private String githubLink;

    @Getter
    private String linkedinLink;

    @Getter
    private String instagramLink;

    @Getter
    private String facebookLink;

    @Getter
    private String twitterLink;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
