package com.wint.Work.Services;

import com.wint.Work.Entitys.Work;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface WorkService {
  public ResponseEntity<List<Work>> findAll();

  public ResponseEntity<Optional<Work>> findById(UUID id);

  public ResponseEntity<Work> create(Work work);

  public ResponseEntity<Work> update(UUID id, Work work);

  public ResponseEntity delete(UUID id);
}
