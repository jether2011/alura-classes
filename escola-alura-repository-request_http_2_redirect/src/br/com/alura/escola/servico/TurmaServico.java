package br.com.alura.escola.servico;

import java.time.LocalDate;
import java.util.List;

import br.com.alura.escola.modelo.Curso;
import br.com.alura.escola.modelo.Turma;

public class TurmaServico {

	Curso java = new Curso("Java OO", "Conceitos básicos de OO", "12 horas");
	Curso spring = new Curso("Spring", "Novidades do spring", "12 horas");
	Curso ejb = new Curso("EJB", "EJB avançado", "16 horas");

	AlunoServico alunoServico = new AlunoServico();

	public List<Turma> listar() {
		return List.of(
				new Turma(LocalDate.of(2019, 4, 3), LocalDate.of(2019,  4, 5), java, alunoServico.listar().get(0) , alunoServico.listar().get(1)),
				new Turma(LocalDate.of(2019, 4, 3), LocalDate.of(2019,  4, 13), spring, alunoServico.listar().get(0)),
				new Turma(LocalDate.of(2019, 4, 17), LocalDate.of(2019, 4, 19), ejb, alunoServico.listar().get(1)));
	}

}
