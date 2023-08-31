package com.wint.Curriculum.Services;

import com.wint.Curriculum.Dtos.CurriculumRequestDTO;
import com.wint.Curriculum.Entitys.Curriculum;
import com.wint.Curriculum.Repositories.CurriculumRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServiceImpl implements CurriculumService {

  @Autowired
  CurriculumRepository curriculumRepository;

  @Override
  public ResponseEntity<List<Curriculum>> findAll() {
    try {
      List<Curriculum> curriculumsList = curriculumRepository.findAll();
      if (curriculumsList.isEmpty()) {
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(curriculumsList);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Optional<Curriculum>> findById(UUID id) {
    try {
      Optional<Curriculum> curriculumOptional = curriculumRepository.findById(
        id
      );
      if (curriculumOptional.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(curriculumOptional);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Curriculum> create(CurriculumRequestDTO curriculumRequestDTO) {
    try {
      var curriculum = new Curriculum();
      BeanUtils.copyProperties(curriculumRequestDTO, curriculum);
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(curriculumRepository.save(curriculum));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @Override
  public ResponseEntity<Curriculum> update(UUID id, CurriculumRequestDTO curriculumRequestDTO) {
    try {
      Optional<Curriculum> curriculumOptional = curriculumRepository.findById(
        id
      );
      if (curriculumOptional.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      var curriculum = curriculumOptional.get();
      BeanUtils.copyProperties(curriculumRequestDTO, curriculum);
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(curriculumRepository.save(curriculum));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @Override
  public ResponseEntity<Object> delete(UUID id) {
    try {
      Optional<Curriculum> curriculumOptional = curriculumRepository.findById(
        id
      );
      if (curriculumOptional.isEmpty()) {
        return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Curriculum not found");
      }
      curriculumRepository.deleteById(id);
      return ResponseEntity
        .status(HttpStatus.OK)
        .body("Curriculum was Deleted");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
