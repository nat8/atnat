package com.epam.natalia_amelina.patterns.decorator;

public abstract class LoginDecorator implements Loggable {

	private Loggable login;
	
	public LoginDecorator(Loggable login) {
		this.login = login;
	}

	public void getLoginInformation() {

	}
}
