package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	//attributes
	private String email;
	private double salario;
	
	//constructor
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String celular, char genero, LocalDate dataNascimento, 
			Endereco endereco, String email, double salario) {
		
		super(nome, cpf, celular, genero, dataNascimento, endereco);
		this.email = email;
		this.salario = salario;
	}
	
	public Funcionario(String nome, String cpf, String celular, char genero, String dataNascimento, 
			Endereco endereco, String email, double salario) {
		
		super(nome, cpf, celular, genero, dataNascimento, endereco);
		this.email = email;
		this.salario = salario;
	}
	
	//getters and setters

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

	//Funcionario nao preciso de hashCode e equals, pois herda de Pessoa;
	
	//toString
	
	@Override
	public String toString() {
		return "Funcionario [email=" + email + ", salario=" + salario + "]";
	}
	
	
	
	
}
