package model;

public class Atendimento {

	private String descricao;
	private double valor;
	private int id;
	private Pet pet;
	private Funcionario funcionario;

	public Atendimento() {
	}

	public Atendimento(String descricao, double valor, int id, Pet pet, Funcionario funcionario) {
		this.descricao = descricao;
		this.valor = valor;
		this.id = id;
		this.pet = pet;
		this.funcionario = funcionario;
	}

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
}
