package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private String email;
	private double salario;
	
	public Funcionario() {
		super();
	}

	public Funcionario(int id, String nome, String cpf, String celular, char genero, LocalDate dataNascimento,
			String endereco) {
		super(id, nome, cpf, celular, genero, dataNascimento, endereco);
	}

	public Funcionario(String email, double salario) {
		super();
		this.email = email;
		this.salario = salario;
	}

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
}
