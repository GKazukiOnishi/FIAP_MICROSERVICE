package com.fiap.produto.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fiap.produto.entity.entities.Produto;
import com.fiap.produto.entity.repositories.ProdutoRepository;
import com.fiap.produto.modelo.PaginacaoModel;
import com.fiap.produto.modelo.ProdutoModel;

import jakarta.validation.Valid;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping("/produtos")
	public ModelAndView index(PaginacaoModel model) {
		ModelAndView modelView = new ModelAndView("produtos/index");
		
		ProdutoModel monitor = new ProdutoModel("Monitor", new BigDecimal(300), 100, 1);
		
		List<ProdutoModel> produtos = Arrays.asList(monitor);
		modelView.addObject("produtos", produtos); //dicionário de dados geralmente
		
		return modelView;
	}

	@PostMapping("/create")
	public ResponseEntity<ProdutoModel> create(@Valid @RequestBody ProdutoModel model) {
		Produto p = new Produto();
		p.setNome(model.getNome());
		p.setDescricao(model.getDescricao());
		p.setQuantidade(model.getQuantidade());
		p.setStatus(model.getStatus());
		p.setValor(model.getValor());
		p.setCodigo(model.getCodigo());
		
		Produto produtoInserido = produtoRepository.save(p);
		
		model.setId(produtoInserido.getId());
		
		return new ResponseEntity<ProdutoModel>(model, HttpStatus.CREATED);
	}
	
	@GetMapping("/produtos/create")
	public ModelAndView create() {
		ModelAndView modelView = new ModelAndView("produtos/create");
		return modelView;
	}

}
