package br.com.sicredi.assembleia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String titulo;
	
	private String local;
	
	private LocalDateTime data;
	
	private List<VotoDTO> votos;
	
	

}
