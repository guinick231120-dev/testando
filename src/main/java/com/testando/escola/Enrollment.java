package com.testando.escola;

public record Enrollment(Student aluno, Course curso, double notaFinal) {
    public boolean aprovado() {
        return notaFinal >= 6.0;
    }
}
