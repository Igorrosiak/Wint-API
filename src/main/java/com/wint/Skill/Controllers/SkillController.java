package com.wint.Skill.Controllers;

import com.wint.Skill.Dtos.SkillRequestDTO;
import com.wint.Skill.Entitys.Skill;
import com.wint.Skill.Services.SkillService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/skill")
public class SkillController {

  @Autowired
  SkillService skillService;

  @GetMapping("/")
  public ResponseEntity<List<Skill>> findAll() {
    return skillService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Skill>> findById(@PathVariable UUID id) {
    return skillService.findById(id);
  }

  @PostMapping("/")
  public ResponseEntity<Skill> create(
    @RequestBody @Valid SkillRequestDTO skillRequestDTO
  ) {
    return skillService.create(skillRequestDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Skill> update(
    @PathVariable UUID id,
    @RequestBody @Valid SkillRequestDTO skillRequestDTO
  ) {
    return skillService.update(id, skillRequestDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable UUID id) {
    return skillService.delete(id);
  }
}
