package com.testando.escola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SchoolManager {
    private final Map<Integer, Student> alunos = new HashMap<>();
    private final Map<Integer, Teacher> professores = new HashMap<>();
    private final Map<Integer, Course> cursos = new HashMap<>();
    private final List<Enrollment> matriculas = new ArrayList<>();

    public Student cadastrarAluno(int id, String nome, String email) {
        Student aluno = new Student(id, nome, email);
        alunos.put(id, aluno);
        return aluno;
    }

    public Teacher cadastrarProfessor(int id, String nome, String disciplina) {
        Teacher professor = new Teacher(id, nome, disciplina);
        professores.put(id, professor);
        return professor;
    }

    public Course cadastrarCurso(int id, String nome, int professorId) {
        Teacher professor = professores.get(professorId);
        if (professor == null) {
            throw new IllegalArgumentException("Professor não encontrado para o ID: " + professorId);
        }
        Course curso = new Course(id, nome, professor);
        cursos.put(id, curso);
        return curso;
    }

    public Enrollment matricularAluno(int alunoId, int cursoId, double notaFinal) {
        Student aluno = alunos.get(alunoId);
        Course curso = cursos.get(cursoId);

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado para o ID: " + alunoId);
        }
        if (curso == null) {
            throw new IllegalArgumentException("Curso não encontrado para o ID: " + cursoId);
        }
        if (notaFinal < 0 || notaFinal > 10) {
            throw new IllegalArgumentException("A nota final deve estar entre 0 e 10.");
        }

        Enrollment matricula = new Enrollment(aluno, curso, notaFinal);
        matriculas.add(matricula);
        return matricula;
    }

    public List<Student> listarAlunos() {
        return new ArrayList<>(alunos.values());
    }

    public List<Teacher> listarProfessores() {
        return new ArrayList<>(professores.values());
    }

    public List<Course> listarCursos() {
        return new ArrayList<>(cursos.values());
    }

    public List<Enrollment> listarMatriculas() {
        return new ArrayList<>(matriculas);
    }

    public Optional<Student> buscarAluno(int id) {
        return Optional.ofNullable(alunos.get(id));
    }

    public Optional<Course> buscarCurso(int id) {
        return Optional.ofNullable(cursos.get(id));
    }
}
