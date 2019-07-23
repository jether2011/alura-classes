package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	Page<Topic> findByCourseName(String courseName, Pageable pagination);

}
