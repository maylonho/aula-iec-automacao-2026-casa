package com.oliveira.aula_iec_automacao.integrations_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.oliveira.aula_iec_automacao.controllers.AlunoController;
import com.oliveira.aula_iec_automacao.models.Aluno;

@SpringBootTest
@ActiveProfiles("test")
class AlunoControllerTest {

    @Autowired
    private AlunoController controller;

    @Test
    void deveCriarAluno() {

        Aluno aluno = new Aluno();

        aluno.setNome("João");
        aluno.setTurma("DSM");
        aluno.setIdade(20);

        Aluno resultado = controller.create(aluno);

        assertTrue(resultado.getId() > 0);
        assertEquals("João", resultado.getNome());
    }

    @Test
    void deveListarAlunos() {

        List<Aluno> alunos = controller.findAll();

        assertTrue(alunos.size() >= 0);
    }

    @Test
    void deveBuscarAlunoPorId() {

        Aluno aluno = new Aluno();

        aluno.setNome("Maria");
        aluno.setTurma("ADS");
        aluno.setIdade(22);

        Aluno criado = controller.create(aluno);

        Aluno resultado = controller.findById(criado.getId());

        assertEquals(criado.getId(), resultado.getId());
        assertEquals("Maria", resultado.getNome());
    }

    @Test
    void deveAtualizarAluno() {

        Aluno aluno = new Aluno();

        aluno.setNome("Carlos");
        aluno.setTurma("SI");
        aluno.setIdade(21);

        Aluno criado = controller.create(aluno);

        criado.setNome("Carlos Atualizado");

        Aluno atualizado = controller.update(
                criado.getId(),
                criado
        );

        assertEquals(
                "Carlos Atualizado",
                atualizado.getNome()
        );
    }

    @Test
    void deveExcluirAluno() {

        Aluno aluno = new Aluno();

        aluno.setNome("Pedro");
        aluno.setTurma("DSM");
        aluno.setIdade(19);

        Aluno criado = controller.create(aluno);

        controller.delete(criado.getId());

        List<Aluno> alunos = controller.findAll();

        boolean existe = alunos.stream()
                .anyMatch(a -> a.getId().equals(criado.getId()));

        assertTrue(!existe);
    }
}