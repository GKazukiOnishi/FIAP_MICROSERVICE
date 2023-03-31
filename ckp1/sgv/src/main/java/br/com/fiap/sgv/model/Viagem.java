package br.com.fiap.sgv.model;

import java.time.LocalDate;

public class Viagem {
	private Trajeto trajeto;
	private LocalDate dataHoraPartida;
	private LocalDate dataHoraChegada;

	public Trajeto getTrajeto() {
		return trajeto;
	}

	public void setTrajeto(Trajeto trajeto) {
		this.trajeto = trajeto;
	}

	public LocalDate getDataHoraPartida() {
		return dataHoraPartida;
	}

	public void setDataHoraPartida(LocalDate dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}

	public LocalDate getDataHoraChegada() {
		return dataHoraChegada;
	}

	public void setDataHoraChegada(LocalDate dataHoraChegada) {
		this.dataHoraChegada = dataHoraChegada;
	}

}
