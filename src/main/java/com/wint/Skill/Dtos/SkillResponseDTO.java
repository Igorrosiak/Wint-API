package com.wint.Skill.Dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SkillResponseDTO(@NotNull UUID id, @NotNull String name, @NotNull String description, @NotNull String icon, @NotNull String user) {
}
