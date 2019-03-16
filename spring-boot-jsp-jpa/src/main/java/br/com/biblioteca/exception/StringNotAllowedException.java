package br.com.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StringNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StringNotAllowedException(String message) {
		super(message);
	}

	public StringNotAllowedException(Throwable throwable) {
		super(throwable);
	}

}