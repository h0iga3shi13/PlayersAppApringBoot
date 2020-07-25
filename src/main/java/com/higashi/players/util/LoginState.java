package com.higashi.players.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginState {

	public static String loginEmail() {
		/*
		 * ログインユーザーの情報を取得する
		 * ログインしていないユーザーには"ゲストユーザー"を返す
		 */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		if (email.equals("anonymousUser")) {
			email = "ゲストユーザー";
		}

		return email;
	}

}
