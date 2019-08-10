package br.com.caelum.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.caelum.distance.domain.restaurant.RestaurantGateway;
import br.com.caelum.distance.domain.restaurant.entities.Restaurant;
import br.com.caelum.distance.resources.restaurant.entities.RestaurantMongo;
import br.com.caelum.distance.resources.restaurant.repository.RestaurantMongoRepository;

@Configuration
public class RestaurantMongoMigration implements CommandLineRunner {

	@Autowired
	private RestaurantGateway restaurantGateway;
	@Autowired
	private RestaurantMongoRepository restaurantMongoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<Restaurant> restaurants = restaurantGateway.findAllByApproved(100);
		
		if(restaurants != null) {
			restaurants
			.stream()
				.forEach(restaurant -> {					
					if(!restaurantMongoRepository.existsById(restaurant.getId())) {
						restaurantMongoRepository.save(RestaurantMongo.from(restaurant));
					}
				});
		}
	}
	
}
