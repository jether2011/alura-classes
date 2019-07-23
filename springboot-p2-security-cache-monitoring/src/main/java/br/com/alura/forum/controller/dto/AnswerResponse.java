package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.alura.forum.modelo.Answer;

public final class AnswerResponse {

	private Long id;
	private String message;
	private LocalDateTime created;
	private String actorName;
	
	public AnswerResponse(Answer answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.created = answer.getCreated();
		this.actorName = answer.getActorName();
	}

	public static AnswerResponse from(Answer answer) {
		return new AnswerResponse(answer);
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return message;
	}

	public LocalDateTime getDataCriacao() {
		return created;
	}

	public String getNomeAutor() {
		return actorName;
	}
	
}
