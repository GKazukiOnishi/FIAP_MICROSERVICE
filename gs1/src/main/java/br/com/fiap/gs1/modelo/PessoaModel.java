package br.com.fiap.gs1.modelo;

import jakarta.validation.constraints.NotBlank;

public class PessoaModel {

	private Long id;
	
	@NotBlank(message = "O nome de pessoa inválido")
	private String nome;
	
	public PessoaModel(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
