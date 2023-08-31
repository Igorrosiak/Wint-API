package com.wint.Recommendation.Controllers;

import com.wint.Recommendation.Dtos.RecommendationRequestDTO;
import com.wint.Recommendation.Entitys.Recommendation;
import com.wint.Recommendation.Services.RecommendationService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

  @Autowired
  RecommendationService recommendationService;

  @GetMapping("/")
  public ResponseEntity<List<Recommendation>> findAll() {
    return recommendationService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Recommendation>> findById(
    @PathVariable UUID id
  ) {
    return recommendationService.findById(id);
  }

  @PostMapping("/")
  public ResponseEntity<Recommendation> create(
    @RequestBody @Valid RecommendationRequestDTO recommendationRequestDTO
  ) {
    return recommendationService.create(recommendationRequestDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Recommendation> update(
    @PathVariable UUID id,
    @RequestBody @Valid RecommendationRequestDTO recommendationRequestDTO
  ) {
    return recommendationService.update(id, recommendationRequestDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable UUID id) {
    return recommendationService.delete(id);
  }
}
