package com.wint.Blog.Services;

import com.wint.Blog.Entitys.Blog;
import com.wint.Blog.Repositories.BlogRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public ResponseEntity<List<Blog>> findAll() {
        try{
            List<Blog> blogsList = blogRepository.findAll();
            if (blogsList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(blogsList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @Override
    public ResponseEntity<Optional<Blog>> findById(UUID id) {
        try {
            Optional<Blog> blogOptional =  blogRepository.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(blogOptional);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Blog> create(Blog blog) {
        try{
            Blog newBlog = blogRepository.save(blog);
            return ResponseEntity.status(HttpStatus.CREATED).body(newBlog);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity update(UUID id, Blog blog) {
        try{
            Optional<Blog> blogOptional =  blogRepository.findById(id);
            if(blogOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found");
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Object> delete(UUID id) {
        try {
            Optional<Blog> blogOptional =  blogRepository.findById(id);
            if(blogOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found");
            }
            blogRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Blog was Deleted");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
