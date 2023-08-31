package com.wint.Work.Services;

import com.wint.Work.Dtos.WorkRequestDTO;
import com.wint.Work.Entitys.Work;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface WorkService {
  public ResponseEntity<List<Work>> findAll();

  public ResponseEntity<Optional<Work>> findById(UUID id);

  public ResponseEntity<Work> create(WorkRequestDTO workRequestDTO);

  public ResponseEntity<Work> update(UUID id, WorkRequestDTO workRequestDTO);

  public ResponseEntity delete(UUID id);
}
