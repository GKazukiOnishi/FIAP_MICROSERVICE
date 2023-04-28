package br.com.fiap.gs1.dto.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.fiap.gs1.dto.ViagemDTO;
import br.com.fiap.gs1.modelo.ViagemModel;

@Component
public class ViagemDTOFactory {

	public ViagemDTO getViagemFromModel(ViagemModel viagemModel) {
		ViagemDTO viagemDTO = new ViagemDTO();
		
		viagemDTO.setId(viagemModel.getId());
		viagemDTO.setDataDecolagem(viagemModel.getDataDecolagemStr());
		viagemDTO.setDataRetorno(viagemModel.getDataRetornoStr());
		viagemDTO.setDuracaoEstadia(viagemModel.getDuracaoEstadia());
		viagemDTO.setMatriculaPrimeiroComandante(viagemModel.getMatriculaPrimeiroComandante());
		viagemDTO.setMatriculaSegundoComandante(viagemModel.getMatriculaSegundoComandante());
		viagemDTO.setNomeModeloNave(viagemModel.getNomeModeloNave());
		viagemDTO.setNomePrimeiroComandante(viagemModel.getNomePrimeiroComandante());
		viagemDTO.setNomeSegundoComandante(viagemModel.getNomeSegundoComandante());
		viagemDTO.setQtdAssentosNave(viagemModel.getQtdAssentosNave());
		
		return viagemDTO;
	}
	
	public List<ViagemDTO> getViagensFromModels(List<ViagemModel> viagensModel) {
		return Optional.ofNullable(viagensModel).map(lista -> lista.stream().map(v -> getViagemFromModel(v)).toList()).orElse(new ArrayList<>());
	}
	
}
