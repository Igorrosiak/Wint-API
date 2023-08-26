package com.wint.User.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "user")
@Entity(name = "user")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @NotNull
    private String name;

    @Getter
    @NotNull
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

    @NotNull
    // Make User model and modify this
    private String user;
}
