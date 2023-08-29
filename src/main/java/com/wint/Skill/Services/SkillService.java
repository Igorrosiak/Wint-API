package com.wint.Skill.Services;

import com.wint.Skill.Entitys.Skill;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface SkillService {
  public ResponseEntity<List<Skill>> findAll();

  public ResponseEntity<Optional<Skill>> findById(UUID id);

  public ResponseEntity<Skill> create(Skill skill);

  public ResponseEntity<Skill> update(UUID id, Skill skill);

  public ResponseEntity delete(UUID id);
}
