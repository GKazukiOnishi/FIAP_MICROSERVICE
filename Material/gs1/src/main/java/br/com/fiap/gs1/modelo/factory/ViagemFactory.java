package br.com.fiap.gs1.modelo.factory;

import org.springframework.stereotype.Component;

import br.com.fiap.gs1.dto.ViagemDTO;
import br.com.fiap.gs1.modelo.ComandanteModel;
import br.com.fiap.gs1.modelo.LocalizacaoModel;
import br.com.fiap.gs1.modelo.NaveModel;
import br.com.fiap.gs1.modelo.ViagemModel;

@Component
public class ViagemFactory {

	public ViagemModel getViagemFromDTO(ViagemDTO dto) {
		LocalizacaoModel origem = new LocalizacaoModel(1l);
		LocalizacaoModel destino = new LocalizacaoModel(2l);
		ComandanteModel primeiroComandante = new ComandanteModel(dto.getNomePrimeiroComandante(), dto.getMatriculaPrimeiroComandante());
		ComandanteModel segundoComandante = new ComandanteModel(dto.getNomeSegundoComandante(), dto.getMatriculaSegundoComandante());
		NaveModel nave = new NaveModel(dto.getNomeModeloNave(), dto.getQtdAssentosNave());
		
		ViagemModel viagem = new ViagemModel(dto.getDataDecolagem(), nave, primeiroComandante, segundoComandante, origem, destino, dto.getDuracaoEstadia());
		
		return viagem;
	}
	
}
