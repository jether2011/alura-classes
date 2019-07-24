package br.com.alura.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicDetailResponse;
import br.com.alura.forum.controller.dto.TopicResponse;
import br.com.alura.forum.controller.form.UpdateTopicForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicRepository;

@RestController
@RequestMapping("/topics")
public class TopicsController {
	
	private static final String TOPICS_PATH_ID = "/topics/{id}";
	private static final String TOPICS = "topics";

	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	@Cacheable(value = TOPICS)
	public Page<TopicResponse> list(@RequestParam(required = false) final String courseName, 
			@PageableDefault(sort = "created", direction = Direction.DESC, page = 0, size = 10) final Pageable pagination) {
		
		if (courseName == null) {
			Page<Topic> topics = topicRepository.findAll(pagination);
			return TopicResponse.from(topics);
		} else {
			Page<Topic> topics = topicRepository.findByCourseName(courseName, pagination);
			return TopicResponse.from(topics);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = TOPICS, allEntries = true)
	public ResponseEntity<TopicResponse> create(@RequestBody @Valid final TopicoForm form, final UriComponentsBuilder uriBuilder) {
		Topic topic = form.toTopic(courseRepository);
		topicRepository.save(topic);
		
		URI uri = uriBuilder.path(TOPICS_PATH_ID).buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicResponse(topic));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TopicDetailResponse> detail(@PathVariable final Long id) {
		Optional<Topic> topic = topicRepository.findById(id);
		if (topic.isPresent()) {
			return ResponseEntity.ok(TopicDetailResponse.from(topic.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = TOPICS, allEntries = true)
	public ResponseEntity<TopicResponse> atualizar(@PathVariable final Long id, 
			@RequestBody @Valid final UpdateTopicForm form) {
		Optional<Topic> topic = topicRepository.findById(id);
		if (topic.isPresent()) {			
			return ResponseEntity.ok(new TopicResponse(form.update(id, topicRepository)));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = TOPICS, allEntries = true)
	public ResponseEntity<?> remover(@PathVariable final Long id) {
		Optional<Topic> topic = topicRepository.findById(id);
		if (topic.isPresent()) {
			topicRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}