package com.oliveira.aula_iec_automacao.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.aula_iec_automacao.models.Aluno;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private com.oliveira.aula_iec_automacao.service.AlunoService service;

    @GetMapping
    public List<com.oliveira.aula_iec_automacao.models.Aluno> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return service.create(aluno);
    }

    @PutMapping
    public Aluno update(@RequestBody Aluno aluno) {
        return service.update(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}