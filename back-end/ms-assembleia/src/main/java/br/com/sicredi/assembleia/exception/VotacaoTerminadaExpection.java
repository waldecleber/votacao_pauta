package br.com.sicredi.assembleia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class VotacaoTerminadaExpection extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VotacaoTerminadaExpection(String msg) {
		super(msg);
	}

}
