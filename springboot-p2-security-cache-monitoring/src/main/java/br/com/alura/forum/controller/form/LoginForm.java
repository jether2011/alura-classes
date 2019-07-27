package br.com.alura.forum.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public final class LoginForm {

	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public final UsernamePasswordAuthenticationToken from() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}

}
