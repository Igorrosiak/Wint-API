package com.wint.Skill.Services;

import com.wint.Skill.Entitys.Skill;
import com.wint.Skill.Repositories.SkillRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

  @Autowired
  SkillRepository skillRepository;

  @Override
  public ResponseEntity<List<Skill>> findAll() {
    try {
      List<Skill> skillsList = skillRepository.findAll();
      if (skillsList.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(skillsList);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Optional<Skill>> findById(UUID id) {
    try {
      Optional<Skill> skillOptional = skillRepository.findById(id);
      if (skillOptional.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(skillOptional);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Skill> create(Skill skill) {
    try {
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(skillRepository.save(skill));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @Override
  public ResponseEntity<Skill> update(UUID id, Skill skill) {
    try {
      Optional<Skill> skillOptional = skillRepository.findById(id);
      if (skillOptional.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(skillRepository.save(skill));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Object> delete(UUID id) {
    try {
      Optional<Skill> skillOptional = skillRepository.findById(id);
      if (skillOptional.isEmpty()) {
        return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Skill not found");
      }
      skillRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK).body("Skill was Deleted");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
