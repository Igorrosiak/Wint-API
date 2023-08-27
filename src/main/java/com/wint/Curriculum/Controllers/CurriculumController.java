package com.wint.Curriculum.Controllers;

import com.wint.Curriculum.Dtos.CurriculumRequestDTO;
import com.wint.Curriculum.Entitys.Curriculum;
import com.wint.Curriculum.Services.CurriculumService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    @Autowired
    CurriculumService curriculumService;

    @GetMapping("s")
    public ResponseEntity<List<Curriculum>> findAll(){
        return curriculumService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curriculum>> findById(@PathVariable UUID id){
        return curriculumService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Curriculum> create(@RequestBody @Valid CurriculumRequestDTO curriculumRequestDTO){
        var curriculum = new Curriculum();
        BeanUtils.copyProperties(curriculumRequestDTO, curriculum);
        return curriculumService.create(curriculum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> update(@PathVariable UUID id, @RequestBody @Valid CurriculumRequestDTO curriculumRequestDTO){
        var curriculum = new Curriculum();
        BeanUtils.copyProperties(curriculumRequestDTO, curriculum);
        return curriculumService.update(id, curriculum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return curriculumService.delete(id);
    }
}
