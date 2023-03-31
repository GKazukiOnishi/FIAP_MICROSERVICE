package br.com.fiap.sgv.model;

public class ConversorDeHorario {

	public Duracao converteDuracaoDecimal(double duracaoDecimal, String formato) {
		int hora = (int) duracaoDecimal;
		int minuto = (int) ((duracaoDecimal - hora) * 60);

		return new Duracao(hora, minuto, formato);
	}

}
