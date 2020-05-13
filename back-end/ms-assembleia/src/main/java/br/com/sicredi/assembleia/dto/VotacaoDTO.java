package br.com.sicredi.assembleia.dto;

import java.io.Serializable;
import java.util.List;

import br.com.sicredi.assembleia.entities.Pauta;
import br.com.sicredi.assembleia.entities.Voto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private PautaDTO pauta;
	
	private Integer total;
	
	private List<VotoDTO> votos;
}
