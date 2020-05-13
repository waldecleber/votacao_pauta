package br.com.sicredi.assembleia.service;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.entities.Pauta;

public interface PautaService {

	public Pauta salvar(PautaDTO pauta);
	
}
