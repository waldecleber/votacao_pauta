package br.com.sicredi.assembleia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sicredi.assembleia.entities.Votacao;

@RepositoryRestResource(collectionResourceRel = "votacao", path = "votacao")
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

	@Query("	SELECT v FROM Votacao v "
			+ "		LEFT JOIN FETCH v.pauta p"
			+ " 	WHERE p.encerrada IS TRUE "
			+ "		ORDER BY p.dataCriacao ")
	List<Votacao> listarVotacoesEmAberto();

}
