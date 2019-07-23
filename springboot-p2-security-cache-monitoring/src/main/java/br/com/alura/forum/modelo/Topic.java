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
	private Course curso;
	@OneToMany(mappedBy = "topico")
	private List<Answer> respostas = new ArrayList<>();
	
	public Topic() {
	}
	
	public Topic(String titulo, String mensagem, Course curso) {
		this.title = titulo;
		this.message = mensagem;
		this.curso = curso;
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return title;
	}

	public void setTitulo(String titulo) {
		this.title = titulo;
	}

	public String getMensagem() {
		return message;
	}

	public void setMensagem(String mensagem) {
		this.message = mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return created;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.created = dataCriacao;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public User getAutor() {
		return actor;
	}

	public void setAutor(User autor) {
		this.actor = autor;
	}

	public Course getCurso() {
		return curso;
	}

	public void setCurso(Course curso) {
		this.curso = curso;
	}

	public List<Answer> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Answer> respostas) {
		this.respostas = respostas;
	}

}
