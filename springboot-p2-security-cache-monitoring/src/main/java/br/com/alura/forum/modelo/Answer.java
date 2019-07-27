package br.com.alura.forum.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public final class Answer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	
	@ManyToOne
	private Topic topic;
	private LocalDateTime created = LocalDateTime.now();
	@ManyToOne
	private User actor;
	private Boolean solution = false;

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
		Answer other = (Answer) obj;
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

	public String getMessage() {
		return message;
	}

	public Topic getTopic() {
		return topic;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public User getActor() {
		return actor;
	}

	public Boolean isSolution() {
		return solution;
	}

	public String getActorName() {
		return getActor().getName();
	}
	
}
