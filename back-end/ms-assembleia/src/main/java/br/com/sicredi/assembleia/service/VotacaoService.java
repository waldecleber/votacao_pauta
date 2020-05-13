package br.com.sicredi.assembleia.service;

import java.util.List;
import java.util.Optional;

import br.com.sicredi.assembleia.dto.VotacaoDTO;
import br.com.sicredi.assembleia.dto.VotoDTO;
import br.com.sicredi.assembleia.entities.Voto;

public interface VotacaoService {

	List<VotacaoDTO> listarVotacoesEmAberto();

	VotacaoDTO realizarVotacao(VotoDTO voto);

	Voto buscarVotoPorAssociado(String cpf, Long idVotacao);
}
