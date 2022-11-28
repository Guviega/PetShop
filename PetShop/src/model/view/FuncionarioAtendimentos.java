package model.view;

import java.util.Objects;

public class FuncionarioAtendimentos {

	private String funcionario;
	private int numero;
	private double valor;

	public FuncionarioAtendimentos(String funcionario, int numero, double valor) {
		this.funcionario = funcionario;
		this.numero = numero;
		this.valor = valor;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public int getNumero() {
		return numero;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcionario, numero, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioAtendimentos other = (FuncionarioAtendimentos) obj;
		return Objects.equals(funcionario, other.funcionario) && numero == other.numero
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
	@Override
	public String toString() {
		return "Nome do funcionário= "+funcionario+ " Numero de atendimentos="+numero+" Valor total="+valor;
	}

}
