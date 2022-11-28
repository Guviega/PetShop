package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import util.Util;

public class Pessoa {

	// attributes

	private int id;
	private String nome, cpf, celular;
	private char genero;
	private LocalDate dataNascimento;
	private Endereco endereco;

	// constructor

	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.genero = genero;
		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
		this.endereco = Util.parseEndereco(endereco);
	}

	public Pessoa(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, String endereco, int id) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.genero = genero;
		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
		this.endereco = Util.parseEndereco(endereco);
		this.id = id;
	}

	public Pessoa(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.genero = genero;
		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
		this.endereco = endereco;
	}

	public Pessoa(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, Endereco endereco, int id) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.genero = genero;
		this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
		this.endereco = endereco;
		this.id = id;
	}

	// getter and setters

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

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = LocalDate.parse(dataNascimento, Util.dateFormatter);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "ID=" + getId() + " Nome=" + getNome() + " Sexo=" + getGenero() + " CPF=" + getCpf() + " Celular="
				+ getCelular() + " Nascimento=" + dataNascimento.format(Util.dateFormatter) + " Endereco="
				+ getEndereco();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			if (((Pessoa) obj).getCpf() == this.getCpf()) {
				return true;
			} else
				return false;
		}
		return false;
	}

}
