package br.com.fiap.gs1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gs1.bean.ViagemBean;
import br.com.fiap.gs1.dto.ViagemDTO;
import br.com.fiap.gs1.dto.factory.ViagemDTOFactory;
import br.com.fiap.gs1.modelo.ViagemModel;
import br.com.fiap.gs1.modelo.factory.ViagemFactory;

@Controller
public class ViagemController {

	@Autowired
	private ViagemFactory viagemFactory;
	@Autowired
	private ViagemDTOFactory viagemDTOFactory;
	@Autowired
	private ViagemBean viagemBean;
	
	@RequestMapping("/viagemTela")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("viagem/index");
		
		List<ViagemModel> viagens = viagemBean.buscaViagens();
		
		modelView.addObject("viagens", viagens);
		
		return modelView;
	}
	
	@RequestMapping("/viagemTela/cadastrar")
	public ModelAndView create() {
		ModelAndView modelView = new ModelAndView("viagem/create");
		
		return modelView;
	}
	
	@GetMapping("/viagem")
	public ResponseEntity<List<ViagemDTO>> busca() {
		List<ViagemModel> viagens = viagemBean.buscaViagens();
		
		return new ResponseEntity<List<ViagemDTO>>(viagemDTOFactory.getViagensFromModels(viagens), HttpStatus.CREATED);
	}
	
	@PostMapping("/viagem")
	public ResponseEntity<ViagemDTO> create(@RequestBody ViagemDTO viagemDTO) {
		ViagemModel viagemModel = viagemFactory.getViagemFromDTO(viagemDTO);
		
		ViagemModel viagemCadastrada = viagemBean.cadastraViagem(viagemModel);
		
		return new ResponseEntity<ViagemDTO>(viagemDTOFactory.getViagemFromModel(viagemCadastrada), HttpStatus.CREATED);
	}
	
	@PutMapping("/viagem/{id}")
	public ResponseEntity<ViagemDTO> update(@RequestBody ViagemDTO viagemDTO, @PathVariable("id") Long idViagem) {
		ViagemModel viagemModel = viagemFactory.getViagemFromDTO(viagemDTO);
		viagemModel.setId(idViagem);
		
		ViagemModel viagemAtualizada = viagemBean.atualizaViagem(viagemModel);
		
		return new ResponseEntity<ViagemDTO>(viagemDTOFactory.getViagemFromModel(viagemAtualizada), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/viagem/{id}")
	public ResponseEntity<Long> delete( @PathVariable("id") Long idViagem) {
		viagemBean.removeViagem(idViagem);
		
		return new ResponseEntity<Long>(idViagem, HttpStatus.NO_CONTENT);
	}
	
}
