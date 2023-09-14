package com.wint.Curriculum.Controllers;

import com.wint.Curriculum.Dtos.CurriculumRequestDTO;
import com.wint.Curriculum.Entitys.Curriculum;
import com.wint.Curriculum.Services.CurriculumService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/curriculum")
public class CurriculumController {

  @Autowired
  CurriculumService curriculumService;

  @GetMapping("/")
  public ResponseEntity<List<Curriculum>> findAll() {
    return curriculumService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Curriculum>> findById(@PathVariable UUID id) {
    return curriculumService.findById(id);
  }

  @PostMapping("/")
  public ResponseEntity<Curriculum> create(
    @RequestBody @Valid CurriculumRequestDTO curriculumRequestDTO
  ) {
    return curriculumService.create(curriculumRequestDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Curriculum> update(
    @PathVariable UUID id,
    @RequestBody @Valid CurriculumRequestDTO curriculumRequestDTO
  ) {
    return curriculumService.update(id, curriculumRequestDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable UUID id) {
    return curriculumService.delete(id);
  }
}
