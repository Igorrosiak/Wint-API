package com.wint.Recommendation.Controllers;

import com.wint.Recommendation.Dtos.RecommendationRequestDTO;
import com.wint.Recommendation.Entitys.Recommendation;
import com.wint.Recommendation.Services.RecommendationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {
    @Autowired
    RecommendationService recommendationService;

    @GetMapping("s")
    public ResponseEntity<List<Recommendation>> findAll(){
        return recommendationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Recommendation>> findById(@PathVariable UUID id){
        return recommendationService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Recommendation> create(@RequestBody @Valid RecommendationRequestDTO recommendationRequestDTO){
        var recommendation = new Recommendation();
        BeanUtils.copyProperties(recommendationRequestDTO, recommendation);
        return recommendationService.create(recommendation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recommendation> update(@PathVariable UUID id, @RequestBody @Valid RecommendationRequestDTO recommendationRequestDTO){
        var recommendation = new Recommendation();
        BeanUtils.copyProperties(recommendationRequestDTO, recommendation);
        return recommendationService.update(id, recommendation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return recommendationService.delete(id);
    }
}
