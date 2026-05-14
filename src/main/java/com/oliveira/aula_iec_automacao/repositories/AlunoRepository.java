package com.oliveira.aula_iec_automacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.aula_iec_automacao.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
}
