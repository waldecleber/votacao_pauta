package br.com.sicredi.assembleia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.dto.VotacaoDTO;
import br.com.sicredi.assembleia.dto.VotoDTO;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.service.VotacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/votacao")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VotacaoController {
	
	private final VotacaoService votacaoService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<VotacaoDTO>> listarVotacoesEmAberto() {		
		return ResponseEntity.ok().body(votacaoService.listarVotacoesEmAberto());
	}
	
	@CrossOrigin
	@PostMapping(path = "/voto")
	public ResponseEntity<VotacaoDTO> realizarVotacao(@RequestBody VotoDTO voto) {    	
		return ResponseEntity.status(HttpStatus.CREATED).body(votacaoService.realizarVotacao(voto));			
	}

}
