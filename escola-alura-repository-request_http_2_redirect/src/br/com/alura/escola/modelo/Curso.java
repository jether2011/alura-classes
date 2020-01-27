package br.com.alura.escola.modelo;

public class Curso {

	public String nome;
	public String ementa;
	public String cargaHoraria;

	public Curso(String nome, String ementa, String cargaHoraria) {
		this.nome = nome;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return nome + " ";
	}
}
