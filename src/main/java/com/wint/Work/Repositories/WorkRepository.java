package com.wint.Work.Repositories;

import com.wint.Work.Entitys.Work;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, UUID> {}
