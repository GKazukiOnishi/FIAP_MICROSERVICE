package br.com.fiap.sgv.trajeto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.fiap.sgv.controller.TrajetoController;
import br.com.fiap.sgv.dto.LocalizacaoDTO;
import br.com.fiap.sgv.dto.TrajetoDTO;

class TestaTrajetoController {

	@Test
	void test() {
		LocalizacaoDTO origem = new LocalizacaoDTO(null, "São Paulo", null, null, null, null, 0);
		LocalizacaoDTO destino = new LocalizacaoDTO(null, "Campos de Jordão", null, null, null, null, 0);
		TrajetoDTO entrada = new TrajetoDTO(origem, destino, 160, 100);
		
		TrajetoController controller = new TrajetoController();
		TrajetoDTO saida = controller.calculaTempoTrajeto(entrada);
		
		assertEquals("1h36", saida.getDuracao().getDuracaoFormatada());
	}

}
