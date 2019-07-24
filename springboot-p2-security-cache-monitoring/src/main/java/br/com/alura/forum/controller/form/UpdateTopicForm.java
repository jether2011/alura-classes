package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.TopicRepository;

public final class UpdateTopicForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;

	private UpdateTopicForm(final String title, final String message) {
		this.title = title;
		this.message = message;
	}

	public static final UpdateTopicForm of(final String title, final String message) {
		return new UpdateTopicForm(title, message);
	}
	
	public Topic update(final Long id, final TopicRepository topicRepository) {
		Topic topic = topicRepository.getOne(id);
		
		topic.setTitle(this.title);
		topic.setMessage(this.message);
		
		return topic;
	}
	
}
