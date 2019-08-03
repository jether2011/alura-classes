package br.com.caelum.distance;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantMongoRepository extends MongoRepository<RestaurantMongo, Long> {

}
