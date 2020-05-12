package br.com.sicredi.assembleia.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

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
	
	@Column(name = "titulo", length = 255)
	private String titulo;
	
	@Column(name = "local")
	private String local;
	
	@Column(name = "data")
	private LocalDateTime data;
	
	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;
	
	

}
