package br.com.sicredi.assembleia.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String cpf;

}
