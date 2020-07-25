package com.higashi.players.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm implements Serializable {

	/*
	 * E-mail()
	 */
	@NotBlank(message = "メールアドレスを入力してください")
	@Size(max = 128)
	private String email;

	/*
	 * password
	 */
	@NotBlank(message = "パスワードを入力してください")
	private String password;
}
