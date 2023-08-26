package com.wint.Work.Repositories;

import com.wint.Work.Entitys.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkRepository extends JpaRepository<Work, UUID> {}
