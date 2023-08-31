package com.wint.Blog.Services;

import com.wint.Blog.Dtos.BlogRequestDTO;
import com.wint.Blog.Entitys.Blog;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface BlogService {
  public ResponseEntity<List<Blog>> findAll();

  public ResponseEntity<Optional<Blog>> findById(UUID id);

  public ResponseEntity<Blog> create(BlogRequestDTO blogRequestDTO);

  public ResponseEntity<Blog> update(UUID id, BlogRequestDTO blogRequestDTO);

  public ResponseEntity delete(UUID id);
}
