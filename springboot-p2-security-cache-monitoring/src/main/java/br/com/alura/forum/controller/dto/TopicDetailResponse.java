package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.TopicStatus;
import br.com.alura.forum.modelo.Topic;

public final class TopicDetailResponse {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime created;
	private String actorName;
	private TopicStatus status;
	private List<AnswerResponse> answers;
	
	private TopicDetailResponse(final Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.created = topic.getCreated();
		this.actorName = topic.getActorName();
		this.status = topic.getStatus();
		this.answers = new ArrayList<>();
		this.answers.addAll(topic.getAnswers().stream().map(AnswerResponse::new).collect(Collectors.toList()));
	}
	
	public final static TopicDetailResponse from(final Topic topic) {
		return new TopicDetailResponse(topic);
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

	public String getActorName() {
		return actorName;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public List<AnswerResponse> getAnswers() {
		return answers;
	}

}
