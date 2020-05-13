package br.com.sicredi.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sicredi.assembleia.entities.Voto;

@RepositoryRestResource(collectionResourceRel = "voto", path = "voto")
public interface VotoRepository extends JpaRepository<Voto, Long> {

}
