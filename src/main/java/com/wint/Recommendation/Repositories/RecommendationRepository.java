package com.wint.Recommendation.Repositories;

import com.wint.Recommendation.Entitys.Recommendation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository
  extends JpaRepository<Recommendation, UUID> {}
