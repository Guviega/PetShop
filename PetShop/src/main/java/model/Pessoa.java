package model;

import java.time.LocalDate;

public class Pessoa {
	
	private int id;
	private String nome, cpf, celular;
	private char genero;
	private LocalDate dataNascimento;
	private String endereco;
	
	public Pessoa() {
	}

	public Pessoa(int id, String nome, String cpf, String celular, char genero, LocalDate dataNascimento,
			String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
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
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
