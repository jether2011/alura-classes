package br.com.alura.escola.modelo;

public class Aluno {

	private String nome;
	private Long cpf;

	public Aluno(String nome, Long cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return nome + " ";
	}
}
