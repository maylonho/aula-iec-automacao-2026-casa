package com.oliveira.aula_iec_automacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.oliveira.aula_iec_automacao.models.Aluno;
import com.oliveira.aula_iec_automacao.repositories.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(
            @PathVariable Long id,
            @RequestBody Aluno aluno) {

        aluno.setId(id);

        return repository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}