package br.com.fiap.gs1.modelo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class NaveModel {

	private Integer id;
	
	@Pattern(regexp = "^[a-z]{4}-[0-9]{4}$", message = "Nome de modelo de nave inválido")
	private String nomeModelo;
	
	@Min(value = 3, message = "A nave deve possuir no mínimo 3 assentos")
	@Pattern(regexp = ""
			+ "^(?:\r\n"
			+ "  [0369] |\r\n"
			+ "  (?:\r\n"
			+ "    [147]\r\n"
			+ "    (?:[147][0369]*[258]|[0369])*\r\n"
			+ "    [258]\r\n"
			+ "  ) |\r\n"
			+ "  (?:\r\n"
			+ "    [258]\r\n"
			+ "    (?:[258][0369]*[147]|[0369])*\r\n"
			+ "    [147]\r\n"
			+ "  )\r\n"
			+ ")+$", message = "A quantidade de assentos deve ser múltiplo de 3")
	private Integer qtdAssentos;
	
	public NaveModel(String nomeModelo, Integer qtdAssentos) {
		super();
		this.nomeModelo = nomeModelo;
		this.qtdAssentos = qtdAssentos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public Integer getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(Integer qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}
	
}
