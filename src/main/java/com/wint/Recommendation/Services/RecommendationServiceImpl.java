package com.wint.Recommendation.Services;

import com.wint.Recommendation.Entitys.Recommendation;
import com.wint.Recommendation.Repositories.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    RecommendationRepository recommendationRepository;

    @Override
    public ResponseEntity<List<Recommendation>> findAll() {
        try{
            List<Recommendation> recommendationsList = recommendationRepository.findAll();
            if (recommendationsList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(recommendationsList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @Override
    public ResponseEntity<Optional<Recommendation>> findById(UUID id) {
        try {
            Optional<Recommendation> recommendationOptional = recommendationRepository.findById(id);
            if(recommendationOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(recommendationOptional);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Recommendation> create(Recommendation recommendation) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(recommendationRepository.save(recommendation));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Recommendation> update(UUID id, Recommendation recommendation) {
        try{
            Optional<Recommendation> recommendationOptional = recommendationRepository.findById(id);
            if(recommendationOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(recommendationRepository.save(recommendation));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Object> delete(UUID id) {
        try {
            Optional<Recommendation> recommendationOptional = recommendationRepository.findById(id);
            if(recommendationOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recommendation not found");
            }
            recommendationRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Recommendation was Deleted");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
