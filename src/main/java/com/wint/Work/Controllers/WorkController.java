package com.wint.Work.Controllers;

import com.wint.Work.Dtos.WorkRequestDTO;
import com.wint.Work.Entitys.Work;
import com.wint.Work.Services.WorkService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkService workService;

    @GetMapping("s")
    public ResponseEntity<List<Work>> findAll(){
        return workService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Work>> findById(@PathVariable UUID id){
        return workService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Work> create(@RequestBody @Valid WorkRequestDTO workRequestDTO){
        var work = new Work();
        BeanUtils.copyProperties(workRequestDTO, work);
        return workService.create(work);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Work> update(@PathVariable UUID id, @RequestBody @Valid WorkRequestDTO workRequestDTO){
        var work = new Work();
        BeanUtils.copyProperties(workRequestDTO, work);
        return workService.update(id, work);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return workService.delete(id);
    }
}
