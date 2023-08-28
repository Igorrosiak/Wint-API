package com.wint.Work.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "works")
@Entity(name = "work")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @NotNull
    private String role;

    @Getter
    @NotNull
    private String localization;

    @Getter
    @NotNull
    private String startDate;

    @Getter
    @NotNull
    private String endDate;

    @Getter
    @NotNull
    private String[] tags;

    @Getter
    @NotNull
    private String[] occupations;

    @NotNull
    // Make User model and modify this
    private String user;
}