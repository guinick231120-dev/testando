package com.testando.escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchoolManagerTest {

    @Test
    void deveCadastrarEntidadesEMatricularAluno() {
        SchoolManager gestor = new SchoolManager();

        gestor.cadastrarAluno(1, "Ana", "ana@email.com");
        gestor.cadastrarProfessor(10, "Carlos", "Matemática");
        gestor.cadastrarCurso(100, "Álgebra", 10);
        Enrollment matricula = gestor.matricularAluno(1, 100, 8.5);

        assertEquals(1, gestor.listarAlunos().size());
        assertEquals(1, gestor.listarProfessores().size());
        assertEquals(1, gestor.listarCursos().size());
        assertEquals(1, gestor.listarMatriculas().size());
        assertTrue(matricula.aprovado());
    }

    @Test
    void deveFalharAoCadastrarCursoSemProfessor() {
        SchoolManager gestor = new SchoolManager();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> gestor.cadastrarCurso(100, "Física", 999)
        );

        assertTrue(exception.getMessage().contains("Professor não encontrado"));
    }
}
