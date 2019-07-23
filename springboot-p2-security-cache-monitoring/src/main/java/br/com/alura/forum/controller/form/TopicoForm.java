package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.CourseRepository;

public final class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String title;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String message;
	
	@NotNull @NotEmpty
	private String courseName;

	private TopicoForm(final String title, final String message, final String courseName) {
		this.title = title;
		this.message = message;
		this.courseName = courseName;
	}

	public static final TopicoForm of(final String title, final String message, final String courseName) {
		return new TopicoForm(title, message, courseName);
	}

	public final Topic from(final CourseRepository cursoRepository) {
		return new Topic(title, message, cursoRepository.findByName(courseName));
	}

}
