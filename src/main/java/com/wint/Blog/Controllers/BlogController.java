package com.wint.Blog.Controllers;

import com.wint.Blog.Entitys.Blog;
import com.wint.Blog.Services.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("s")
    public ResponseEntity<List<Blog>> findAll(){
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Blog>> findById(@PathVariable UUID id){
        return blogService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Blog> create(@RequestBody @Valid BlogRequestDTO blogRequestDTO){
        var blog = new Blog();
        BeanUtils.copyProperties(blogRequestDTO, blog);
        return blogService.create(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable UUID id, @RequestBody @Valid BlogRequestDTO blogRequestDTO){
        var blog = new Blog();
        BeanUtils.copyProperties(blogRequestDTO, blog);
        return blogService.update(id, blog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return blogService.delete(id);
    }
}
