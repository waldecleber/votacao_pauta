package br.com.sicredi.assembleia.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import br.com.sicredi.assembleia.dto.AssociadoDTO;
import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.dto.VotacaoDTO;
import br.com.sicredi.assembleia.dto.VotoDTO;
import br.com.sicredi.assembleia.entities.Associado;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.entities.Votacao;
import br.com.sicredi.assembleia.entities.Voto;
import br.com.sicredi.assembleia.exception.CpfVotoUnicoExpection;
import br.com.sicredi.assembleia.repository.VotacaoRepository;
import br.com.sicredi.assembleia.repository.VotoRepository;
import br.com.sicredi.assembleia.service.impl.VotacaoServiceImpl;
import br.com.sicredi.assembleia.service.impl.VotoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class VotacaoServiceTest {
	
	@InjectMocks
	private VotoServiceImpl votoService;
	
	@InjectMocks
	private VotacaoServiceImpl votacaoService;
	
	@Mock 
	private VotacaoRepository votacaoRepository;
	
	@Mock
	private VotoRepository votoRepository;
	
	@Test
	public void buscarVotacaoPorCpfSucesso() {
		when(votoRepository.findVotoPorAssociado(anyString(), anyLong()))				
			.thenReturn(Optional.of(Voto.builder().build()));
		votacaoService.buscarVotoPorAssociado("57343172760", 1L);
		verify(votoRepository, times(1)).findVotoPorAssociado(anyString(), anyLong());
	}
	
	@Test
	public void realizaUmVotoNaPautaSucesso() {		
		Pauta pauta = Pauta.builder()
				.titulo("Deseja votar no item vermelho?")
				.dataCriacao(LocalDateTime.now())
				.dataValidade(LocalDateTime.now().plusDays(2L))
				.build();
		
		Associado associado = Associado.builder()
				.nome("Joao da Silva")
				.cpf("57343172760")
				.build();
		
		Votacao votacao = Votacao.builder()
				.pauta(pauta)
				.build();
		
		Voto voto = Voto.builder()
				.associado(associado)
				.resposta(Boolean.TRUE)
				.votacao(votacao)
				.build();
		
		when(votoRepository.save(any(Voto.class))).thenReturn(voto);		
		votoService.realizarVotacao(voto);		
		verify(votoRepository, times(1)).save(voto);
	}
	
	@Test(expected = CpfVotoUnicoExpection.class)
	public void cpfJaVotouNaMesmaPautaException() {		
		
		PautaDTO pauta = PautaDTO.builder()
				.titulo("Deseja votar no item vermelho?")
				.dataCriacao(LocalDateTime.now())
				.dataValidade(LocalDateTime.now().plusDays(2L))
				.build();
		
		AssociadoDTO associado = AssociadoDTO.builder()
				.nome("Joao da Silva")
				.cpf("57343172760")
				.build();
		
		VotacaoDTO votacao = VotacaoDTO.builder()
				.pauta(pauta)
				.build();
		
		VotoDTO votoDto1 = VotoDTO.builder()
				.associado(associado)
				.resposta(Boolean.FALSE)
				.votacao(votacao)
				.build();
		
//		Voto voto = Voto.builder()
//				.associado(associado)
//				.resposta(Boolean.TRUE)
//				.votacao(votacao)
//				.build();
		
//		when(votoRepository.save(any(Voto.class))).thenReturn(voto);		
//		votoService.realizarVotacao(voto);		
//		verify(votoRepository, times(1)).save(voto);
		
		VotoDTO votoDto2 = VotoDTO.builder()
				.associado(associado)
				.resposta(Boolean.FALSE)
				.votacao(votacao)
				.build();
		
		Voto votoObj = new Voto();
		
		BeanUtils.copyProperties(votoDto2, votoObj);
		
		
		when(votoRepository.findVotoPorAssociado(anyString(), anyLong()))				
			.thenReturn(Optional.of(Voto.builder().build()));
		votacaoService.buscarVotoPorAssociado(associado.getCpf(), 1L);
		verify(votoRepository, times(1)).findVotoPorAssociado(anyString(), anyLong());
	
	
//		when(votoRepository.save(any(Voto.class))).thenReturn(votoObj);		
		votacaoService.realizarVotacao(votoDto2);		
		verify(votoRepository, times(1)).save(votoObj);
	}
	
//	@Test(expected = VotacaoTerminadaExpection.class)
//	public void realizaUmVotoSessaoTerminadaException() {	
//		Pauta pauta = Pauta.builder()
//				.titulo("Deseja votar no item vermelho?")
//				.data(LocalDateTime.now())
//				.build();
//		
//		Associado associado = Associado.builder()
//				.nome("Joao da Silva")
//				.cpf("57343172760")
//				.build();
//		
//		Voto voto = Voto.builder()
//				.associado(associado)
//				.pauta(pauta)
//				.resposta(Boolean.TRUE)
//				.build();
//		
//		when(votoRepository.save(any(Voto.class))).thenReturn(voto);
//		
//		votoService.realizarVotacao(voto);
//		
//		verify(votoRepository, times(1)).save(voto);
//	}

}
