package com.testando.escola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SchoolManager gestor = new SchoolManager();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("\n===== Gestão Escolar =====");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Cadastrar professor");
            System.out.println("3. Cadastrar curso");
            System.out.println("4. Matricular aluno");
            System.out.println("5. Listar dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            try {
                switch (opcao) {
                    case 1 -> cadastrarAluno(scanner, gestor);
                    case 2 -> cadastrarProfessor(scanner, gestor);
                    case 3 -> cadastrarCurso(scanner, gestor);
                    case 4 -> matricularAluno(scanner, gestor);
                    case 5 -> listarDados(gestor);
                    case 0 -> executando = false;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Aplicação encerrada.");
    }

    private static void cadastrarAluno(Scanner scanner, SchoolManager gestor) {
        System.out.print("ID do aluno: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Email do aluno: ");
        String email = scanner.nextLine();

        gestor.cadastrarAluno(id, nome, email);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private static void cadastrarProfessor(Scanner scanner, SchoolManager gestor) {
        System.out.print("ID do professor: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Disciplina do professor: ");
        String disciplina = scanner.nextLine();

        gestor.cadastrarProfessor(id, nome, disciplina);
        System.out.println("Professor cadastrado com sucesso.");
    }

    private static void cadastrarCurso(Scanner scanner, SchoolManager gestor) {
        System.out.print("ID do curso: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("ID do professor responsável: ");
        int professorId = Integer.parseInt(scanner.nextLine());

        gestor.cadastrarCurso(id, nome, professorId);
        System.out.println("Curso cadastrado com sucesso.");
    }

    private static void matricularAluno(Scanner scanner, SchoolManager gestor) {
        System.out.print("ID do aluno: ");
        int alunoId = Integer.parseInt(scanner.nextLine());
        System.out.print("ID do curso: ");
        int cursoId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nota final (0 a 10): ");
        double nota = Double.parseDouble(scanner.nextLine());

        Enrollment matricula = gestor.matricularAluno(alunoId, cursoId, nota);
        System.out.println("Matrícula realizada. Situação: " + (matricula.aprovado() ? "Aprovado" : "Reprovado"));
    }

    private static void listarDados(SchoolManager gestor) {
        System.out.println("\n--- Alunos ---");
        gestor.listarAlunos().forEach(aluno ->
                System.out.println(aluno.id() + " - " + aluno.nome() + " (" + aluno.email() + ")"));

        System.out.println("\n--- Professores ---");
        gestor.listarProfessores().forEach(professor ->
                System.out.println(professor.id() + " - " + professor.nome() + " / " + professor.disciplina()));

        System.out.println("\n--- Cursos ---");
        gestor.listarCursos().forEach(curso ->
                System.out.println(curso.id() + " - " + curso.nome() + " | Professor: " + curso.professor().nome()));

        System.out.println("\n--- Matrículas ---");
        gestor.listarMatriculas().forEach(matricula ->
                System.out.println(matricula.aluno().nome() + " -> " + matricula.curso().nome()
                        + " | Nota: " + matricula.notaFinal()
                        + " | " + (matricula.aprovado() ? "Aprovado" : "Reprovado")));
    }
}
