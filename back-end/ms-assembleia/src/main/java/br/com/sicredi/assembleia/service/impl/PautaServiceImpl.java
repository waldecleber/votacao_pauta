package br.com.sicredi.assembleia.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.repository.PautaRepository;
import br.com.sicredi.assembleia.service.PautaService;

@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	public Pauta salvar(PautaDTO pautaDTO) {
		Pauta pauta = new Pauta();
		BeanUtils.copyProperties(pautaDTO, pauta);
		return pautaRepository.save(pauta);
	}

}
