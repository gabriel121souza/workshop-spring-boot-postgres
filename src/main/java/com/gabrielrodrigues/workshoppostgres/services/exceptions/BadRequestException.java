package com.gabrielrodrigues.workshoppostgres.services.exceptions;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1;

	public BadRequestException(String msg) {
		super(msg);
	}
}
