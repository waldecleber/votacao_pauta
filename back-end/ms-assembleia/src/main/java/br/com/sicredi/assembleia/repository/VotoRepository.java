package br.com.sicredi.assembleia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sicredi.assembleia.entities.Voto;

@RepositoryRestResource(collectionResourceRel = "voto", path = "voto")
public interface VotoRepository extends JpaRepository<Voto, Long> {

	@Query(" SELECT v FROM Voto v "
			+ "	LEFT JOIN FETCH Associado a "
			+ "	LEFT JOIN FETCH Votacao vt "
			+ " WHERE a.cpf = :cpf "
			+ "	AND vt.id = :idVotacao")
	Optional<Voto> findVotoPorAssociado(@Param("cpf") String cpf, @Param("idVotacao") Long idVotacao);

}
