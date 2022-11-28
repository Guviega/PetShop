package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import util.Util;

public class Atendimento {

	// attributes

	private String descricao;
	private double valor;
	private int id;
	private LocalDate data;
	private Pet pet;
	private Funcionario funcionario;

	// constructor

	public Atendimento() {
	}

	public Atendimento(String descricao, double valor, String data, DateTimeFormatter formatter, Pet pet,
			Funcionario funcionario) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.data = LocalDate.parse(data, formatter);
		this.pet = pet;
		this.funcionario = funcionario;
	}

	public Atendimento(String descricao, double valor, String data, DateTimeFormatter formatter, Pet pet,
			Funcionario funcionario, int id) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.id = id;
		this.data = LocalDate.parse(data, formatter);
		this.pet = pet;
		this.funcionario = funcionario;
	}

	// getters and setters

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) {
		this.data = LocalDate.parse(data, Util.dateFormatter);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	// hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + id;
		result = prime * result + ((pet == null) ? 0 : pet.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Atendimento) {
			if (((Atendimento) obj).getId() == this.getId()) {
				return true;
			} else
				return false;
		}
		return false;
	}

	// toString

	@Override
	public String toString() {
		return "ID= "+id+" Descricao=" + descricao + " Valor=" + valor + " Pet=" + pet.getNome()
				+ " Funcionario=" + funcionario.getNome();
	}

}
