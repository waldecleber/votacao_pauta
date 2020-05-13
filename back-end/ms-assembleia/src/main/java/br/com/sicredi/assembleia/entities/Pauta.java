package br.com.sicredi.assembleia.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pauta")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pauta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", length = 255)
	private String titulo;
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "data")
	private LocalDateTime data;
	
	@OneToMany(mappedBy = "pauta")
	private List<Voto> votos;
	
	

}
