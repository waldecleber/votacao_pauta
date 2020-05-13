package br.com.sicredi.assembleia.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cpfService", url = "https://api-valida-cpf.herokuapp.com")
public interface CpfService {

	@GetMapping("/valida/{cpf}")
	String validaCpf(@PathVariable("cpf") String cpf);
}
