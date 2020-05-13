package br.com.sicredi.assembleia.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.entities.Voto;
import br.com.sicredi.assembleia.repository.PautaRepository;
import br.com.sicredi.assembleia.repository.VotacaoRepository;
import br.com.sicredi.assembleia.service.impl.PautaServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PautaServiceTest {
	
	@InjectMocks
	private PautaServiceImpl pautaService;
	
	@Mock
	private PautaRepository pautaRepository;
	
	@Mock
	private VotacaoRepository votacaoRepository;
	
	@Test
	public void salvaUmaPautaComSucesso() {
		PautaDTO pautaDTO = PautaDTO.builder()
				.titulo("Deseja votar no item vermelho?")
				.build();
		pautaDTO.setDataCriacao(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
		pautaDTO.setEncerrada(Boolean.FALSE);
		
		Pauta pauta = new Pauta();
		BeanUtils.copyProperties(pautaDTO, pauta);
		
		when(pautaRepository.save(any(Pauta.class))).thenReturn(pauta);
		pautaService.salvar(pautaDTO);
		verify(pautaRepository, times(1)).save(pauta);	
		
	}

}
