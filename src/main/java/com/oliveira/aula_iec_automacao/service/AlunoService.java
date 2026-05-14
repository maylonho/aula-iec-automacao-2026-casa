package com.oliveira.aula_iec_automacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.aula_iec_automacao.models.Aluno;
import com.oliveira.aula_iec_automacao.repositories.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Long id) {
        return repository.findById(id).get();
    }

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno update(Aluno aluno) {
        return repository.save(aluno);
    }

    public void delete(Long id) {

        Aluno aluno = repository.findById(id).get();

        repository.delete(aluno);
    }
}