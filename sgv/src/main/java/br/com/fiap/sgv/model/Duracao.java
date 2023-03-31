package br.com.fiap.sgv.model;

public class Duracao {
	private int hora;
	private int minuto;
	private String formato;
	
	public Duracao(int hora, int minuto, String formato) {
		super();
		this.hora = hora;
		this.minuto = minuto;
		this.formato = formato;
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

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return String.format(formato, hora, minuto);
	}
}
