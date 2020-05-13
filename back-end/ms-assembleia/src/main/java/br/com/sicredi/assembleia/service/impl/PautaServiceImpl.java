package br.com.sicredi.assembleia.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.entities.Votacao;
import br.com.sicredi.assembleia.repository.PautaRepository;
import br.com.sicredi.assembleia.repository.VotacaoRepository;
import br.com.sicredi.assembleia.service.PautaService;
import br.com.sicredi.assembleia.util.ModelMapperConverter;

@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	public Pauta salvar(PautaDTO pautaDTO) {
		Pauta pauta = Pauta.builder().build();
		pautaDTO.setDataCriacao(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
		pautaDTO.setEncerrada(Boolean.FALSE);
		
		BeanUtils.copyProperties(pautaDTO, pauta);
		pautaRepository.save(pauta);
		
		Votacao votacao = Votacao.builder().pauta(pauta).build();
		votacaoRepository.save(votacao);
		
		return pauta;
	}

	@Override
	public List<PautaDTO> listarPautasEmAberto() {
		return ModelMapperConverter.mapList(pautaRepository.listarPautasEmAberto(), PautaDTO.class);
	}

}
