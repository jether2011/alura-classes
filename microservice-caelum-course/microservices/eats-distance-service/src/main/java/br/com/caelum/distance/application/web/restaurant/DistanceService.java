package br.com.caelum.distance.application.web.restaurant;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.caelum.distance.application.web.restaurant.response.RestaurantDistanceDto;
import br.com.caelum.distance.application.web.util.exceptions.ResourceNotFoundException;
import br.com.caelum.distance.domain.restaurant.entities.Restaurant;
import br.com.caelum.distance.resources.restaurant.entities.RestaurantMongo;
import br.com.caelum.distance.resources.restaurant.repository.RestaurantMongoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class DistanceService {

	private static final Pageable LIMIT = PageRequest.of(0, 5);


	private RestaurantMongoRepository mongoRepository;

	public void save(Restaurant restaurant) {
		mongoRepository.insert(RestaurantMongo.from(restaurant));
	}
	
	public List<RestaurantDistanceDto> restaurantsNearestCep(String cep) {
		Page<RestaurantMongo> restaurants = mongoRepository.findAll(LIMIT);
		return calculateDistanceToRestaurants(restaurants.getContent(), cep);
	}

	public List<RestaurantDistanceDto> restaurantsCookTypeNearestCep(Long cookTypeId, String cep) {
		Page<RestaurantMongo> cookTypeApproveds = mongoRepository.findAllBycookId(cookTypeId, LIMIT);
		return calculateDistanceToRestaurants(cookTypeApproveds.getContent(), cep);
	}

	public RestaurantDistanceDto restaurantDistanceCep(Long restauranteId, String cep) {
		RestaurantMongo restaurant = mongoRepository.findById(restauranteId).orElseThrow(() -> new ResourceNotFoundException());
		return new RestaurantDistanceDto(restauranteId, cepDistance(restaurant.getCep(), cep));
	}

	private List<RestaurantDistanceDto> calculateDistanceToRestaurants(List<RestaurantMongo> restaurants, String cep) {
		return restaurants
				.stream()
				.map(restaurant -> {
					String restaurantCep = restaurant.getCep();
					BigDecimal distance = cepDistance(restaurantCep, cep);
					Long restaurantId = restaurant.getId();
					return new RestaurantDistanceDto(restaurantId, distance);
				})
				.collect(Collectors.toList());
	}

	private BigDecimal cepDistance(String restaurantCep, String cep) {
		return calculateDistance();
	}

	private BigDecimal calculateDistance() {
		//simulateDeliveryInWaiting();
		return new BigDecimal(Math.random()*15);
	}

	@SuppressWarnings("unused")
	private void simulateDeliveryInWaiting() {
		long demora = (long) (Math.random()*10000+10000);
		try {
			Thread.sleep(demora);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
