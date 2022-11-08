package model;

import java.time.LocalDate;

public class Pet {

	private int id;
	private String nome, tipo, raca, cor;
	private LocalDate datanascimento;
	private Pessoa dono;

	public Pet() {
	}

	public Pet(String nome, String tipo, String raca, String cor, LocalDate dtNasc, Pessoa dono) {
		this.cor = cor;
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.dono = dono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Pessoa getDono() {
		return this.dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
	
}
