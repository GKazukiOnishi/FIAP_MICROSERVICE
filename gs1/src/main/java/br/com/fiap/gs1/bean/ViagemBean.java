package br.com.fiap.gs1.bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fiap.gs1.modelo.ComandanteModel;
import br.com.fiap.gs1.modelo.LocalizacaoModel;
import br.com.fiap.gs1.modelo.NaveModel;
import br.com.fiap.gs1.modelo.ViagemModel;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class ViagemBean {
	
	public ViagemModel cadastraViagem(@Valid ViagemModel viagem) {
		//TODO cadastro fake
		return viagem;
	}

	public ViagemModel atualizaViagem(@Valid ViagemModel viagem) {
		// TODO atualização fake
		return viagem;
	}

	public Long removeViagem(Long id) {
		// TODO deleção fake
		return id;
	}

	public List<ViagemModel> buscaViagens() {
		// TODO busca fake
		NaveModel nave = new NaveModel("aaaa-9999", 30);
		ComandanteModel comandante = new ComandanteModel("Kazuki", "XXX-9999-X9X");
		ComandanteModel comandante2 = new ComandanteModel("Gabriel", "XXX-9999-X9X");
		LocalizacaoModel origem = new LocalizacaoModel(1l);
		LocalizacaoModel destino = new LocalizacaoModel(2l);
		ViagemModel viagem1 = new ViagemModel(1l, LocalDate.now(), null, nave, comandante, comandante2, origem, destino, 100);
		return Arrays.asList(viagem1);
	}
	
}
