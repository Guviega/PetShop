package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import util.Util;

public class Pet {

	//attributes
	
	private int id;
	private String nome, tipo, raca, cor;
	private LocalDate datanascimento;
	private Pessoa dono;

	//constructor 
	
	public Pet() {
	}

	public Pet(String nome, String tipo, String raca, String cor, String dtNasc, DateTimeFormatter formatter, Pessoa dono) {
		this.cor = cor;
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.dono = dono;
		this.datanascimento = LocalDate.parse(dtNasc, formatter);
	}
	
	public Pet(String nome, String tipo, String raca, String cor, String dtNasc, DateTimeFormatter formatter, Pessoa dono, int id) {
		this.cor = cor;
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.dono = dono;
		this.datanascimento = LocalDate.parse(dtNasc, formatter);
		this.id = id;
	}
	
	//getters and setters

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
	
	public void setDatanascimento(String data) {
		this.datanascimento = LocalDate.parse(data, Util.dateFormatter);
	}

	public Pessoa getDono() {
		return this.dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
	//hashCode e equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((datanascimento == null) ? 0 : datanascimento.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((raca == null) ? 0 : raca.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pet) {
			if (((Pet) obj).getId() == getId())
				return true;
			else return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ID=" + id + " Nome=" + nome + " Tipo=" + tipo + " Raca=" + raca + " Cor=" + cor
				+ " Nascimento=" + datanascimento + " Dono=" + dono.getNome();
	}

}
