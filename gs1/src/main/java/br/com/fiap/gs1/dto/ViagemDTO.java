package br.com.fiap.gs1.dto;

public class ViagemDTO {
	private Long id;
	private String dataDecolagem;
	private String dataRetorno;
	private Integer duracaoEstadia;
	private Integer qtdAssentosNave;
	private String nomeModeloNave;
	private String nomePrimeiroComandante;
	private String nomeSegundoComandante;
	private String matriculaPrimeiroComandante;
	private String matriculaSegundoComandante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(String dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public String getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Integer getDuracaoEstadia() {
		return duracaoEstadia;
	}

	public void setDuracaoEstadia(Integer duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}

	public Integer getQtdAssentosNave() {
		return qtdAssentosNave;
	}

	public void setQtdAssentosNave(Integer qtdAssentosNave) {
		this.qtdAssentosNave = qtdAssentosNave;
	}

	public String getNomeModeloNave() {
		return nomeModeloNave;
	}

	public void setNomeModeloNave(String nomeModeloNave) {
		this.nomeModeloNave = nomeModeloNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}

}
