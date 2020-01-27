package br.com.alura.escola.modelo;

import java.time.LocalDate;
import java.util.List;

public class Turma {

	private LocalDate inicio;
	private LocalDate fim;
	private Curso curso;
	private List<Aluno> alunos;

	public Turma(LocalDate inicio, LocalDate fim, Curso curso, Aluno ...aluno) {
		this.inicio = inicio;
		this.fim = fim;
		this.curso = curso;
		this.alunos = List.of(aluno);
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public Curso getCurso() {
		return curso;
	}

	@Override
	public String toString() {
		return "\nInicio da turma: " + inicio
				+ "\nFim da turma: " + fim
				+ "\nCurso: " + curso.nome
				+ "\nAluno> " + alunos;
	}
}
