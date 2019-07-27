package br.com.caelum.distance;

import java.util.List;
import java.util.Optional;

public interface RestaurantGateway {
	
	Optional<Restaurant> findById(final Long restaurantId);
	List<Restaurant> findAllByApprovedAndCookType(final Long cookTypeId, final int limit);
	List<Restaurant> findAllByApproved(final int limit);
	
}
