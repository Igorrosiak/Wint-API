package com.wint.Recommendation.Services;

import com.wint.Recommendation.Entitys.Recommendation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecommendationService {
    public ResponseEntity<List<Recommendation>> findAll();
    public ResponseEntity<Optional<Recommendation>> findById(UUID id);
    public ResponseEntity<Recommendation> create(Recommendation recommendation);
    public ResponseEntity<Recommendation> update(UUID id, Recommendation Recommendation);
    public ResponseEntity delete(UUID id);
}
