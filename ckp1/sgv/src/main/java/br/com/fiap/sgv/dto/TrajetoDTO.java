package br.com.fiap.sgv.dto;

public class TrajetoDTO {
	private LocalizacaoDTO origem;
	private LocalizacaoDTO destino;
	private double distancia;
	private double velocidadeMedia;
	private DuracaoDTO duracao;
	
	public TrajetoDTO(LocalizacaoDTO origem, LocalizacaoDTO destino, double distancia, double velocidadeMedia,
			DuracaoDTO duracao) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.velocidadeMedia = velocidadeMedia;
		this.duracao = duracao;
	}

	public TrajetoDTO(LocalizacaoDTO origem, LocalizacaoDTO destino, double distancia, double velocidadeMedia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.velocidadeMedia = velocidadeMedia;
	}
	
	public DuracaoDTO getDuracao() {
		return duracao;
	}

	public void setDuracao(DuracaoDTO duracao) {
		this.duracao = duracao;
	}

	public LocalizacaoDTO getOrigem() {
		return origem;
	}

	public void setOrigem(LocalizacaoDTO origem) {
		this.origem = origem;
	}

	public LocalizacaoDTO getDestino() {
		return destino;
	}

	public void setDestino(LocalizacaoDTO destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

}
