package br.com.sicredi.assembleia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "associado")
@SequenceGenerator(name = "associadoSequenceGen", sequenceName = "associado_id_seq", allocationSize = 1)
@Data
@Builder
public class Associado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "associadoSequenceGen", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String nome;
	
	private String cpf;

}
