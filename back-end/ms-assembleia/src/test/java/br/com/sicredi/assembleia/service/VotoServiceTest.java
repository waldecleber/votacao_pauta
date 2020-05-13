package br.com.sicredi.assembleia.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.assembleia.entities.Associado;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.entities.Voto;
import br.com.sicredi.assembleia.exception.VotacaoTerminadaExpection;
import br.com.sicredi.assembleia.repository.VotoRepository;
import br.com.sicredi.assembleia.service.impl.VotoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class VotoServiceTest {
	
	@InjectMocks
	private VotoServiceImpl votoService;
	
	@Mock
	private VotoRepository votoRepository;
	
	@Test
	public void realizaUmVotoNaPautaSucesso() {		
		Pauta pauta = Pauta.builder()
				.titulo("Deseja votar no item vermelho?")
				.data(LocalDateTime.now())
				.build();
		
		Associado associado = Associado.builder()
				.nome("Joao da Silva")
				.cpf("57343172760")
				.build();
		
		Voto voto = Voto.builder()
				.associado(associado)
				.pauta(pauta)
				.resposta(Boolean.TRUE)
				.build();
		
		when(votoRepository.save(any(Voto.class))).thenReturn(voto);
		
		votoService.realizarVotacao(voto);
		
		verify(votoRepository, times(1)).save(voto);
	}
	
	@Test(expected = VotacaoTerminadaExpection.class)
	public void realizaUmVotoSessaoTerminadaException() {	
		Pauta pauta = Pauta.builder()
				.titulo("Deseja votar no item vermelho?")
				.data(LocalDateTime.now())
				.build();
		
		Associado associado = Associado.builder()
				.nome("Joao da Silva")
				.cpf("57343172760")
				.build();
		
		Voto voto = Voto.builder()
				.associado(associado)
				.pauta(pauta)
				.resposta(Boolean.TRUE)
				.build();
		
		when(votoRepository.save(any(Voto.class))).thenReturn(voto);
		
		votoService.realizarVotacao(voto);
		
		verify(votoRepository, times(1)).save(voto);
	}

}
