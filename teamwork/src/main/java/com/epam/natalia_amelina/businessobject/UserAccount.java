package com.epam.natalia_amelina.businessobject;

public class UserAccount {

	private String login;
	private String password;
	
	public UserAccount(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
}
