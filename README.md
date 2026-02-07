# Gestão Escolar em Java

Aplicativo de linha de comando para gestão escolar com cadastro de:

- Alunos
- Professores
- Cursos
- Matrículas (com nota final e situação de aprovação)

## Requisitos

- Java 17+
- Maven 3.9+

## Como executar

```bash
mvn clean compile
mvn exec:java
```

## Como testar

```bash
mvn test
```

## Funcionalidades

No menu principal você pode:

1. Cadastrar aluno
2. Cadastrar professor
3. Cadastrar curso (vinculado a professor)
4. Matricular aluno em curso com nota final
5. Listar todos os dados cadastrados
