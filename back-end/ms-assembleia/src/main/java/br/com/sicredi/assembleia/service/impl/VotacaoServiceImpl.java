package br.com.sicredi.assembleia.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import static java.util.Objects.isNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.assembleia.dto.VotacaoDTO;
import br.com.sicredi.assembleia.dto.VotoDTO;
import br.com.sicredi.assembleia.entities.Voto;
import br.com.sicredi.assembleia.exception.CpfVotoUnicoExpection;
import br.com.sicredi.assembleia.repository.VotacaoRepository;
import br.com.sicredi.assembleia.repository.VotoRepository;
import br.com.sicredi.assembleia.service.VotacaoService;
import br.com.sicredi.assembleia.util.ModelMapperConverter;

@Service
public class VotacaoServiceImpl implements VotacaoService {
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	@Autowired
	private VotoRepository votoRepository;

	@Override
	public List<VotacaoDTO> listarVotacoesEmAberto() {
		return ModelMapperConverter.mapList(votacaoRepository.listarVotacoesEmAberto(), VotacaoDTO.class);
	}

	@Override
	public VotacaoDTO realizarVotacao(VotoDTO votoDTO) {
		if (isNull(buscarVotoPorAssociado(votoDTO.getAssociado().getCpf(), votoDTO.getVotacao().getId()))) {
			
			votoDTO.setData(LocalDateTime.now());		
			
			Voto voto = new Voto();		
			BeanUtils.copyProperties(votoDTO, voto);	
			
			votoRepository.save(voto);		
			return votoDTO.getVotacao();
			
		} else {
			throw new CpfVotoUnicoExpection("Este CPF já votou para esta pauta.");
		}
		
	}
	
	public Voto buscarVotoPorAssociado(String cpf, Long idVotacao) {
		return votoRepository.findVotoPorAssociado(cpf, idVotacao)
			.orElseThrow(() -> new CpfVotoUnicoExpection("Este CPF já votou para esta pauta."));
		
	}

}
