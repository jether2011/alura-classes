package br.com.caelum.distance.resources.restaurant;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;

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

	@Value(value = "${service.restaurants.url}")
	private String serviceMainHost;
	
	@Override
	public Optional<Restaurant> findById(final Long restaurantId) {		
		Restaurant restaurant = Unirest.get(this.serviceMainHost + "/restaurantes/{id}")
									.header("Accept", "application/json")
									.routeParam("id", restaurantId.toString())
									.asObject(Restaurant.class)
									.getBody();		
		
		return Optional.of(restaurant);
	}

	@Override
	public List<Restaurant> findAllByApprovedAndCookType(final Long cookTypeId, final int limit) {
		return Unirest.get(this.serviceMainHost + "/restaurantes/{approved}/{cookTypeId}")
				.header("Accept", "application/json")
				.routeParam("approved", "true")
				.routeParam("cookTypeId", cookTypeId.toString())
				.asObject(new GenericType<List<Restaurant>>(){})
				.getBody();
	}

	@Override
	public List<Restaurant> findAllByApproved(final int limit) {
		return Unirest.get(this.serviceMainHost + "/restaurantes/aprovados")
				.header("Accept", "application/json")
				.asObject(new GenericType<List<Restaurant>>(){})
				.getBody();
	}
}
