package br.com.sicredi.assembleia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private boolean resposta;
	
	private LocalDateTime data;

	private AssociadoDTO associado;
	
	private PautaDTO pauta;
	
	
}
