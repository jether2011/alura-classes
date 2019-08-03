package br.com.caelum.distance.domain.restaurant;

import java.util.List;
import java.util.Optional;

import br.com.caelum.distance.domain.restaurant.entities.Restaurant;

public interface RestaurantGateway {
	
	Optional<Restaurant> findById(final Long restaurantId);
	List<Restaurant> findAllByApprovedAndCookType(final Long cookTypeId, final int limit);
	List<Restaurant> findAllByApproved(final int limit);
	
}
