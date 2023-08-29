package com.wint.Work.Services;

import com.wint.Work.Entitys.Work;
import com.wint.Work.Repositories.WorkRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

  @Autowired
  WorkRepository workRepository;

  @Override
  public ResponseEntity<List<Work>> findAll() {
    try {
      List<Work> worksList = workRepository.findAll();
      if (worksList.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(worksList);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Optional<Work>> findById(UUID id) {
    try {
      Optional<Work> workOptional = workRepository.findById(id);
      if (workOptional.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(workOptional);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Work> create(Work work) {
    try {
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(workRepository.save(work));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @Override
  public ResponseEntity<Work> update(UUID id, Work work) {
    try {
      Optional<Work> workOptional = workRepository.findById(id);
      if (workOptional.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(workRepository.save(work));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Object> delete(UUID id) {
    try {
      Optional<Work> workOptional = workRepository.findById(id);
      if (workOptional.isEmpty()) {
        return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Work not found");
      }
      workRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK).body("Work was Deleted");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
