package com.wint.Blog.Repositories;

import com.wint.Blog.Entitys.Blog;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, UUID> {}
