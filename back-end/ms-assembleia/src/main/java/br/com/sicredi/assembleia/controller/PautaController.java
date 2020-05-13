package br.com.sicredi.assembleia.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembleia.dto.PautaDTO;
import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.service.PautaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pautas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PautaController {
	
	private final PautaService pautaService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Pauta> salvar(@RequestBody PautaDTO pauta) {    	
		return ResponseEntity.status(HttpStatus.CREATED).body(pautaService.salvar(pauta));			
	}

}
