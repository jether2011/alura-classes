package br.com.caelum.distance;

import java.util.List;
import java.util.Optional;

public final class RestaurantGatewayImpl implements RestaurantGateway {

	@Override
	public Optional<Restaurant> findById(final Long restaurantId) {
		return null;
	}

	@Override
	public List<Restaurant> findAllByApprovedAndCookType(final Long cookTypeId, final int limit) {
		final boolean approved = true;
		return null;
	}

	@Override
	public List<Restaurant> findAllByApproved(final int limit) {
		final boolean approved = true;
		return null;
	}

}
