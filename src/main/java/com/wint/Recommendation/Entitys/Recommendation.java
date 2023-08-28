package com.wint.Recommendation.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "recommendations")
@Entity(name = "recommendation")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @NotNull
    private String description;

    @Getter
    @NotNull
    private String relationship;

    @NotNull
    // Make User model and modify this
    private String recommendedUser;

    @Getter
    @NotNull
    // Make User model and modify this
    private String userWhoRecommended;
}
