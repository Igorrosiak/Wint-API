package com.wint.Blog.Services;

import com.wint.Blog.Entitys.Blog;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlogService {
    public ResponseEntity<List<Blog>> findAll();
    public ResponseEntity<Optional<Blog>> findById(UUID id);
    public ResponseEntity<Blog> create(Blog blog);
    public ResponseEntity<Blog> update(UUID id, Blog blog);
    public ResponseEntity delete(UUID id);
}
