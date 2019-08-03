package br.com.caelum.distance.resources.restaurant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.distance.resources.restaurant.entities.RestaurantMongo;

@Repository
public interface RestaurantMongoRepository extends MongoRepository<RestaurantMongo, Long> {

	Page<RestaurantMongo> findAll(Pageable limit);
	Page<RestaurantMongo> findAllBycookId(Long cookId, Pageable limit);
	
}
