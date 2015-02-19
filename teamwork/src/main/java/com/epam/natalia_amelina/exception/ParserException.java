package com.epam.natalia_amelina.exception;

public class ParserException extends RuntimeException {
	
	private static final String ERROR = "ERROR! Test suite file incorrect! ";
	
	private static final long serialVersionUID = 983241635256073760L;
	
	public ParserException(String e) {
		super(ERROR + e);
	}

}
