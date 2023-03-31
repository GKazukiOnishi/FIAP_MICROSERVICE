package br.com.fiap.sgv.dto;

public class DuracaoDTO {
	private int hora;
	private int minuto;
	private String duracaoFormatada;

	public DuracaoDTO(int hora, int minuto, String duracaoFormatada) {
		super();
		this.hora = hora;
		this.minuto = minuto;
		this.duracaoFormatada = duracaoFormatada;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getDuracaoFormatada() {
		return duracaoFormatada;
	}

	public void setDuracaoFormatada(String duracaoFormatada) {
		this.duracaoFormatada = duracaoFormatada;
	}

}
