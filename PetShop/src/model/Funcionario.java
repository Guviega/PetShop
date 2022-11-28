package model;

import java.time.format.DateTimeFormatter;

import util.Util;

public class Funcionario extends Pessoa {

	// attributes
	private String email;
	private double salario;

	// constructor
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, String endereco, String email, double salario) {
		super(nome, cpf, celular, genero, dataNascimento, formatter, endereco);
		this.email = email;
		this.salario = salario;
	}

	public Funcionario(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, String endereco, String email, double salario, int id) {
		super(nome, cpf, celular, genero, dataNascimento, formatter, endereco, id);
		this.email = email;
		this.salario = salario;
	}

	public Funcionario(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, Endereco endereco, String email, double salario) {
		super(nome, cpf, celular, genero, dataNascimento, formatter, endereco, genero);
		this.email = email;
		this.salario = salario;
	}

	public Funcionario(String nome, String cpf, String celular, char genero, String dataNascimento,
			DateTimeFormatter formatter, Endereco endereco, String email, double salario, int id) {
		super(nome, cpf, celular, genero, dataNascimento, formatter, endereco, id);
		this.email = email;
		this.salario = salario;
	}

	// getters and setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	// toString

	@Override
	public String toString() {
		return "ID=" + getId() + " Nome=" + getNome() + " Sexo=" + getGenero() + " CPF=" + getCpf() + " Celular="
				+ getCelular() + " Nascimento=" + getDataNascimento().format(Util.dateFormatter) + " Endereco="
				+ getEndereco() + " Email=" + getEmail() + " Salario=" + getSalario();
	}

}
