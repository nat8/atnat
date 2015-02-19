package com.epam.natalia_amelina.patterns.singleton;

import com.epam.natalia_amelina.businessobject.UserAccount;

public class SingleAccount {

	private static final String USER_LOGIN = "ivnivnov@inbox.ru";
	private static final String USER_PASSWORD = "ivn70jhf";
	
	private static UserAccount userAccount;
	
	private SingleAccount() {
		
	}
	
	public static UserAccount getUserAccount() {
		if (userAccount == null) {
			userAccount = new UserAccount(USER_LOGIN, USER_PASSWORD);
		}
		return userAccount;
	}
}
