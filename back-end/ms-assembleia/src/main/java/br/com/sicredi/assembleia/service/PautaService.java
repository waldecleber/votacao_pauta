package br.com.sicredi.assembleia.service;

import java.util.List;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.entities.Pauta;

public interface PautaService {

	Pauta salvar(PautaDTO pauta);

	List<PautaDTO> listarPautasEmAberto();
	
}
