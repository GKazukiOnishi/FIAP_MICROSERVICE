package br.com.fiap.sgv.model;

public class Passagem {
	private long numeroBilhete;
	private Viagem viagem;
	private Cliente cliente;
	private int numeroAssento;

	public long getNumeroBilhete() {
		return numeroBilhete;
	}

	public void setNumeroBilhete(long numeroBilhete) {
		this.numeroBilhete = numeroBilhete;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumeroAssento() {
		return numeroAssento;
	}

	public void setNumeroAssento(int numeroAssento) {
		this.numeroAssento = numeroAssento;
	}

}
