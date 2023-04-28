package br.com.fiap.gs1.modelo;

import jakarta.validation.constraints.Pattern;

public class ComandanteModel extends PessoaModel {

	@Pattern(regexp = "^[A-Z]{3}-[0-9]{4}-[A-Z]{1}[0-9]{1}[A-Z]{1}$", message = "Matrícula interespacial inválido")
	private String matricula;

	public ComandanteModel(String nome, String matricula) {
		super(nome);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
