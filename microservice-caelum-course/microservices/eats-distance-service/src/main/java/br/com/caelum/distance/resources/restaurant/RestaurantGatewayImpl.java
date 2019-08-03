package br.com.caelum.distance.resources.restaurant;

import java.util.List;
import java.util.Optional;

import br.com.caelum.distance.domain.restaurant.RestaurantGateway;
import br.com.caelum.distance.domain.restaurant.entities.Restaurant;
import kong.unirest.GenericType;
import kong.unirest.Unirest;

/**
 * 
 * @author jether.rodrigues
 * 03/08/2019
 * 
 * http://kong.github.io/unirest-java/#shutting-down
 */
public final class RestaurantGatewayImpl implements RestaurantGateway {

	private final static String MAIN_HOST = "";
	
	@Override
	public Optional<Restaurant> findById(final Long restaurantId) {		
		Restaurant restaurant = Unirest.get(MAIN_HOST + "{id}")
									.header("Accept", "application/json")
									.routeParam("id", restaurantId.toString())
									.asObject(Restaurant.class)
									.getBody();		
		
		return Optional.of(restaurant);
	}

	@Override
	public List<Restaurant> findAllByApprovedAndCookType(final Long cookTypeId, final int limit) {
		return Unirest.get(MAIN_HOST + "{approved}/{cookTypeId}")
				.header("Accept", "application/json")
				.routeParam("approved", "true")
				.routeParam("cookTypeId", cookTypeId.toString())
				.asObject(new GenericType<List<Restaurant>>(){})
				.getBody();
	}

	@Override
	public List<Restaurant> findAllByApproved(final int limit) {
		return Unirest.get(MAIN_HOST + "{approved}")
				.header("Accept", "application/json")
				.routeParam("approved", "true")
				.asObject(new GenericType<List<Restaurant>>(){})
				.getBody();
	}
}
