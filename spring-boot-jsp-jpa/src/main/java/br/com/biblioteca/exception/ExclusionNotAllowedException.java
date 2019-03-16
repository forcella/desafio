package br.com.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExclusionNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExclusionNotAllowedException(String message) {
		super(message);
	}

	public ExclusionNotAllowedException(Throwable throwable) {
		super(throwable);
	}

}