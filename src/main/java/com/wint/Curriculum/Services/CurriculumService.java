package com.wint.Curriculum.Services;

import com.wint.Curriculum.Entitys.Curriculum;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CurriculumService {
    public ResponseEntity<List<Curriculum>> findAll();
    public ResponseEntity<Optional<Curriculum>> findById(UUID id);
    public ResponseEntity<Curriculum> create(Curriculum curriculum);
    public ResponseEntity<Curriculum> update(UUID id, Curriculum curriculum);
    public ResponseEntity delete(UUID id);
}
