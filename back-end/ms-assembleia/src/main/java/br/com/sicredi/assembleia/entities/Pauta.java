package br.com.sicredi.assembleia.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import antlr.collections.List;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "pauta")
@SequenceGenerator(name = "pautaSequenceGen", sequenceName = "pauta_id_seq", allocationSize = 1)
@Data
@Builder
public class Pauta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "associadoSequenceGen", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String titulo;
	
	private String local;
	
	private LocalDateTime data;
	
	@OneToMany(mappedBy = "pauta")
	private List votos;
	
	

}
