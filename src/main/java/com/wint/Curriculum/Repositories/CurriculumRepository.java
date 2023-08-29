package com.wint.Curriculum.Repositories;

import com.wint.Curriculum.Entitys.Curriculum;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, UUID> {}
