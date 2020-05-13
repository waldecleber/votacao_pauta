package br.com.sicredi.assembleia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sicredi.assembleia.entities.Pauta;

@RepositoryRestResource(collectionResourceRel = "pauta", path = "pauta")
public interface PautaRepository extends JpaRepository<Pauta, Long> {

	@Query("	SELECT p FROM Pauta p "
			+ " 	WHERE p.encerrada <> TRUE "
			+ "		ORDER BY p.dataCriacao ")
	List<Pauta> listarPautasEmAberto();

}
