package br.com.alura.forum.controller.dto;

public class TokenResponse {

	private String token;
	private String type;

	private TokenResponse(final String token, final String type) {
		this.token = token;
		this.type = type;
	}
	
	public static TokenResponse of(final String token, final String type) {
		return new TokenResponse(token, type);
	}

	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}

}
