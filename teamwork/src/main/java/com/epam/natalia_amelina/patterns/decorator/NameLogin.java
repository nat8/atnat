package com.epam.natalia_amelina.patterns.decorator;

public class NameLogin extends LoginDecorator {

	private String name;
	private String lastName;
	
	public NameLogin(Loggable login, String name, String lastName) {
		super(login);
		this.name = name;
		this.lastName = lastName;
	}

	public void getInformation() {

	}
}
