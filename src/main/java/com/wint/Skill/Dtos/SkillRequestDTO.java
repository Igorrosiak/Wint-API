package com.wint.Skill.Dtos;

import jakarta.validation.constraints.NotNull;

public record SkillRequestDTO(@NotNull String name, @NotNull String description, @NotNull String icon, @NotNull String user) {
}
