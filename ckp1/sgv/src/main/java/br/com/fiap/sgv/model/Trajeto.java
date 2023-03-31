package br.com.fiap.sgv.model;

public class Trajeto {
	private Localizacao origem;
	private Localizacao destino;
	private double distancia;
	private double velocidadeMedia;

	public Trajeto(Localizacao origem, Localizacao destino, double distancia, double velocidadeMedia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.velocidadeMedia = velocidadeMedia;
	}

	public double calculaTempoTrajeto(double distancia, double velocidadeMedia) {
		double tempo = distancia / velocidadeMedia;
		return tempo;
	}

	public Localizacao getOrigem() {
		return origem;
	}

	public void setOrigem(Localizacao origem) {
		this.origem = origem;
	}

	public Localizacao getDestino() {
		return destino;
	}

	public void setDestino(Localizacao destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

}
