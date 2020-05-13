package br.com.sicredi.assembleia.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.entities.Voto;
import br.com.sicredi.assembleia.repository.VotoRepository;
import br.com.sicredi.assembleia.service.VotoService;

@Service
public class VotoServiceImpl implements VotoService {
	
	@Autowired
	private VotoRepository votoRepository;
	
	public void realizarVotacao(Voto voto) {
		voto.setData(LocalDateTime.now());		
		votoRepository.save(voto);		
	}

}
