package br.com.fiap.gs1.service;

import br.com.fiap.gs1.modelo.LocalizacaoModel;

public class EstimaTempoViagemService {

	public EstimaTempoViagemService() {
		super();
	}

	public Double estimarEmDias(LocalizacaoModel origem, LocalizacaoModel destino) {
		//Serviço realiza cálculos e chama outros serviços para estimar tempo de viagem em dias
		//Processo mockado para testes
		return 260d;
	}
	
}
