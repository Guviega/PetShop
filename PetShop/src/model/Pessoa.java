package model;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {
	
	//attributes
	
	private int id;
	private String nome, cpf, celular;
	private char genero;
	private LocalDate dataNascimento;
	private Endereco endereco;
	
	//constructor 
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String celular, char genero, LocalDate dataNascimento, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	//getter and setters
	
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	//hashCode and equals
	
	@Override
	public int hashCode() {
		return Objects.hash(celular, cpf, dataNascimento, endereco, genero, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(genero, other.genero) && id == other.id && Objects.equals(nome, other.nome);
	}
	
	//toString 
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", genero=" + genero
				+ ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + "]";
	}

	
}
