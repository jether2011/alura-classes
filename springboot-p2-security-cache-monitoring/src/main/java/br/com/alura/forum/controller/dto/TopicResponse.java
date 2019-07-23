package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topic;

public final class TopicResponse {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime created;
	
	public TopicResponse(final Topic topico) {
		this.id = topico.getId();
		this.title = topico.getTitle();
		this.message = topico.getMessage();
		this.created = topico.getCreated();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public static Page<TopicResponse> to(Page<Topic> topics) {
		return topics.map(TopicResponse::new);
	}
}
