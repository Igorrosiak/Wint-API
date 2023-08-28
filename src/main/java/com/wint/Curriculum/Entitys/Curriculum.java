package com.wint.Curriculum.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "curriculums")
@Entity(name = "curriculum")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @NotNull
    private String name;

    @Getter
    @NotNull
    private String tag;

    @Getter
    @NotNull
    private String image;

    @Getter
    @NotNull
    // Make User model and modify this
    private String userId;
}
