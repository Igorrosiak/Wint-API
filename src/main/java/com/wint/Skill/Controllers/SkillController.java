package com.wint.Skill.Controllers;

import com.wint.Skill.Dtos.SkillRequestDTO;
import com.wint.Skill.Entitys.Skill;
import com.wint.Skill.Services.SkillService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/")
    public ResponseEntity<List<Skill>> findAll(){
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Skill>> findById(@PathVariable UUID id){
        return skillService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Skill> create(@RequestBody @Valid SkillRequestDTO skillRequestDTO){
        var skill = new Skill();
        BeanUtils.copyProperties(skillRequestDTO, skill);
        return skillService.create(skill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable UUID id, @RequestBody @Valid SkillRequestDTO skillRequestDTO){
        var skill = new Skill();
        BeanUtils.copyProperties(skillRequestDTO, skill);
        return skillService.update(id, skill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        return skillService.delete(id);
    }
}
