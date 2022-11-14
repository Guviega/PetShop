package model;

import java.time.LocalDate;

public class Pet {

	//attributes
	
	private int id;
	private String nome, tipo, raca, cor;
	private LocalDate datanascimento;
	private Pessoa dono;

	//constructor 
	
	public Pet() {
	}

	public Pet(String nome, String tipo, String raca, String cor, LocalDate dtNasc, Pessoa dono) {
		this.cor = cor;
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.dono = dono;
		this.datanascimento = dtNasc;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (datanascimento == null) {
			if (other.datanascimento != null)
				return false;
		} else if (!datanascimento.equals(other.datanascimento))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (raca == null) {
			if (other.raca != null)
				return false;
		} else if (!raca.equals(other.raca))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", raca=" + raca + ", cor=" + cor
				+ ", datanascimento=" + datanascimento + ", dono=" + dono + "]";
	}

}
