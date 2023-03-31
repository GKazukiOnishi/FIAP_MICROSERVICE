package br.com.fiap.sgv.controller;

import br.com.fiap.sgv.dto.DuracaoDTO;
import br.com.fiap.sgv.dto.LocalizacaoDTO;
import br.com.fiap.sgv.dto.TrajetoDTO;
import br.com.fiap.sgv.model.ConversorDeHorario;
import br.com.fiap.sgv.model.Duracao;
import br.com.fiap.sgv.model.Localizacao;
import br.com.fiap.sgv.model.Trajeto;

public class TrajetoController {

	public TrajetoDTO calculaTempoTrajeto(TrajetoDTO trajeto) {
		ConversorDeHorario conversor = new ConversorDeHorario();
		LocalizacaoDTO origem = trajeto.getOrigem();
		Localizacao origemModel = converteLocalizacao(origem);
		LocalizacaoDTO destino = trajeto.getDestino();

		Localizacao destinoModel = converteLocalizacao(destino);
		Trajeto trajetoModel = new Trajeto(origemModel, destinoModel, trajeto.getDistancia(),
				trajeto.getVelocidadeMedia());

		double tempoTrajeto = trajetoModel.calculaTempoTrajeto(trajetoModel.getDistancia(),
				trajetoModel.getVelocidadeMedia());

		String formatoDeDuracao = "%sh%s";
		Duracao duracaoModel = conversor.converteDuracaoDecimal(tempoTrajeto, formatoDeDuracao);

		DuracaoDTO duracaoDTO = new DuracaoDTO(duracaoModel.getHora(), duracaoModel.getMinuto(),
				duracaoModel.toString());
		TrajetoDTO retornoDTO = new TrajetoDTO(origem, destino, tempoTrajeto, tempoTrajeto, duracaoDTO);

		return retornoDTO;
	}

	private Localizacao converteLocalizacao(LocalizacaoDTO localizacao) {
		return new Localizacao(localizacao.getCep(), localizacao.getCidade(), localizacao.getEstado(),
				localizacao.getLogradouro(), localizacao.getComplemento(), localizacao.getBairro(),
				localizacao.getNumero());
	}
}
