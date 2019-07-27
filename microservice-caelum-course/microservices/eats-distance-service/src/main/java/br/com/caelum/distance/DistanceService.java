package br.com.caelum.distance;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.caelum.distance.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class DistanceService {

	private static final int LIMIT = 10;


	private RestaurantGateway restaurantGateway;

	public List<RestaurantDistanceDto> restaurantsNearestCep(String cep) {
		List<Restaurant> approveds = restaurantGateway.findAllByApproved(LIMIT);
		return calculateDistanceToRestaurants(approveds, cep);
	}

	public List<RestaurantDistanceDto> restaurantsCookTypeNearestCep(Long cookTypeId, String cep) {
		List<Restaurant> cookTypeApproveds = restaurantGateway.findAllByApprovedAndCookType(cookTypeId, LIMIT);
		return calculateDistanceToRestaurants(cookTypeApproveds, cep);
	}

	public RestaurantDistanceDto restaurantDistanceCep(Long restauranteId, String cep) {
		Restaurant restaurant = restaurantGateway.findById(restauranteId).orElseThrow(() -> new ResourceNotFoundException());
		return new RestaurantDistanceDto(restauranteId, cepDistance(restaurant.getCep(), cep));
	}

	private List<RestaurantDistanceDto> calculateDistanceToRestaurants(List<Restaurant> restaurants, String cep) {
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
