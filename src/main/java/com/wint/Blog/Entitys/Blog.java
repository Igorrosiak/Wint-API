package com.wint.Blog.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

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

    @NotNull
    // Make User model and modify this
    private String user;
}
