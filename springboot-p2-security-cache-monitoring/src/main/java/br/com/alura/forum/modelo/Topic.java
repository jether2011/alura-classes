package br.com.alura.forum.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public final class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String message;
	private LocalDateTime created = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private TopicStatus status = TopicStatus.NOT_ANSWERED;
	@ManyToOne
	private User actor;
	@ManyToOne
	private Course course;
	@OneToMany(mappedBy = "topic")
	private List<Answer> answers = new ArrayList<>();
	
	public Topic() {
	}
	
	public Topic(String title, String message, Course course) {
		this.title = title;
		this.message = message;
		this.course = course;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public TopicStatus getStatus() {
		return status;
	}

	public User getActor() {
		return actor;
	}

	public Course getCourse() {
		return course;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public String getActorName() {
		return this.actor.getName();
	}

	public void setTitle(final String title) {
		this.title = title;	
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
