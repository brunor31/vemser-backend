package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorEntity post(@RequestBody ProfessorEntity professorEntity){
        professorRepository.save(professorEntity);
        return professorEntity;
    }

    @GetMapping
    public List<ProfessorEntity> getAll(){
        return professorRepository.findAll();
    }
}
