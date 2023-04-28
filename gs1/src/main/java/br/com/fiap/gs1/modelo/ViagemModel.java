package br.com.fiap.gs1.modelo;

import java.time.LocalDate;

import br.com.fiap.gs1.service.EstimaTempoViagemService;
import br.com.fiap.gs1.util.DateUtil;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class ViagemModel {

	private Long id;
	private LocalDate dataDecolagem;
	private LocalDate dataRetorno;
	private NaveModel nave;
	private ComandanteModel primeiroComandante;
	private ComandanteModel segundoComandante;
	private LocalizacaoModel origem;
	private LocalizacaoModel destino;

	@Min(value = 1, message = "A duração de estadia deve ser no mínimo 1 dia")
	private Integer duracaoEstadia;
	
	@Pattern(regexp = DateUtil.regexFormatDefault, message = "Formato de data inválida")
	private String dataDecolagemStr;
	
	private EstimaTempoViagemService estimador = new EstimaTempoViagemService();

	public ViagemModel(String dataDecolagem, NaveModel nave, ComandanteModel primeiroComandante,
			ComandanteModel segundoComandante, LocalizacaoModel origem, LocalizacaoModel destino,
			Integer duracaoEstadia) {
		super();
		this.dataDecolagemStr = dataDecolagem;
		this.nave = nave;
		this.primeiroComandante = primeiroComandante;
		this.segundoComandante = segundoComandante;
		this.origem = origem;
		this.destino = destino;
		this.duracaoEstadia = duracaoEstadia;
	}

	public ViagemModel(Long id, LocalDate dataDecolagem, LocalDate dataRetorno, NaveModel nave,
			ComandanteModel primeiroComandante, ComandanteModel segundoComandante, LocalizacaoModel origem,
			LocalizacaoModel destino, Integer duracaoEstadia) {
		super();
		this.id = id;
		this.dataDecolagem = dataDecolagem;
		this.dataRetorno = dataRetorno;
		this.nave = nave;
		this.primeiroComandante = primeiroComandante;
		this.segundoComandante = segundoComandante;
		this.origem = origem;
		this.destino = destino;
		this.duracaoEstadia = duracaoEstadia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDataDecolagemStr() {
		if (dataDecolagemStr == null && dataDecolagem != null) {
			dataDecolagemStr = DateUtil.getFormatted(dataDecolagem);
		}
		return dataDecolagemStr;
	}

	public void setDataDecolagemStr(String dataDecolagemStr) {
		this.dataDecolagemStr = dataDecolagemStr;
	}

	public LocalDate getDataDecolagem() {
		if (dataDecolagem == null && dataDecolagemStr != null) {
			dataDecolagem = DateUtil.getFromString(dataDecolagemStr);
		}
		return dataDecolagem;
	}

	public void setDataDecolagem(LocalDate dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public LocalDate getDataRetorno() {
		if (dataRetorno == null) {
			calculaDataRetorno();
		}
		return dataRetorno;
	}
	
	public String getDataRetornoStr() {
		if (dataRetorno != null) {
			return DateUtil.getFormatted(dataRetorno);
		}
		return null;
	}

	private void calculaDataRetorno() {
		Double duracaoDiasIda = estimador.estimarEmDias(origem, destino);
		Double duracaoDiasVolta = estimador.estimarEmDias(destino, origem);
		Long totalDias = duracaoDiasIda.longValue() + duracaoDiasVolta.longValue() + duracaoEstadia;
		dataRetorno = DateUtil.somarDias(getDataDecolagem(), totalDias);
	}

	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Integer getDuracaoEstadia() {
		return duracaoEstadia;
	}

	public void setDuracaoEstadia(Integer duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}

	public NaveModel getNave() {
		return nave;
	}

	public void setNave(NaveModel nave) {
		this.nave = nave;
	}

	public ComandanteModel getPrimeiroComandante() {
		return primeiroComandante;
	}

	public void setPrimeiroComandante(ComandanteModel primeiroComandante) {
		this.primeiroComandante = primeiroComandante;
	}

	public ComandanteModel getSegundoComandante() {
		return segundoComandante;
	}

	public void setSegundoComandante(ComandanteModel segundoComandante) {
		this.segundoComandante = segundoComandante;
	}

	public LocalizacaoModel getOrigem() {
		return origem;
	}

	public void setOrigem(LocalizacaoModel origem) {
		this.origem = origem;
	}

	public LocalizacaoModel getDestino() {
		return destino;
	}

	public void setDestino(LocalizacaoModel destino) {
		this.destino = destino;
	}

	public String getMatriculaPrimeiroComandante() {
		if (primeiroComandante != null) {
			return primeiroComandante.getMatricula();
		}
		return null;
	}

	public String getMatriculaSegundoComandante() {
		if (segundoComandante != null) {
			return segundoComandante.getMatricula();
		}
		return null;
	}

	public String getNomeModeloNave() {
		if (nave != null) {
			return nave.getNomeModelo();
		}
		return null;
	}

	public String getNomePrimeiroComandante() {
		if (primeiroComandante != null) {
			return primeiroComandante.getNome();
		}
		return null;
	}

	public String getNomeSegundoComandante() {
		if (segundoComandante != null) {
			return segundoComandante.getNome();
		}
		return null;
	}

	public Integer getQtdAssentosNave() {
		if (nave != null) {
			return nave.getQtdAssentos();
		}
		return null;
	}

}
