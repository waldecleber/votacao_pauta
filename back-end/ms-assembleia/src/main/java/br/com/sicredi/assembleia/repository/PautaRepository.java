package br.com.sicredi.assembleia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.sicredi.assembleia.entities.Pauta;

@RepositoryRestResource(collectionResourceRel = "pauta", path = "pauta")
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
