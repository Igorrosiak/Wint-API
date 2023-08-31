package com.wint.Work.Controllers;

import com.wint.Work.Dtos.WorkRequestDTO;
import com.wint.Work.Entitys.Work;
import com.wint.Work.Services.WorkService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work")
public class WorkController {

  @Autowired
  WorkService workService;

  @GetMapping("/")
  public ResponseEntity<List<Work>> findAll() {
    return workService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Work>> findById(@PathVariable UUID id) {
    return workService.findById(id);
  }

  @PostMapping("/")
  public ResponseEntity<Work> create(
    @RequestBody @Valid WorkRequestDTO workRequestDTO
  ) {
    return workService.create(workRequestDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Work> update(
    @PathVariable UUID id,
    @RequestBody @Valid WorkRequestDTO workRequestDTO
  ) {
    return workService.update(id, workRequestDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable UUID id) {
    return workService.delete(id);
  }
}
