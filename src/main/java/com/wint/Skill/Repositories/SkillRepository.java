package com.wint.Skill.Repositories;

import com.wint.Skill.Entitys.Skill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.wint.User.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, UUID> {}
