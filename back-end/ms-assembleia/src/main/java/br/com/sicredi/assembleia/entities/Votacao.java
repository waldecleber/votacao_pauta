package br.com.sicredi.assembleia.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "votacao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Votacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "id_pauta")
	@OneToOne(fetch = FetchType.LAZY)
	private Pauta pauta;
	
	@Column(name = "total_votos")
	private Integer total;
	
	@OneToMany(mappedBy = "votacao")
	private List<Voto> votos;
	
}
