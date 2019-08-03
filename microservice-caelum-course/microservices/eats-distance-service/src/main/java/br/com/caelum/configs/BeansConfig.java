package br.com.caelum.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.caelum.distance.domain.restaurant.RestaurantGateway;
import br.com.caelum.distance.resources.restaurant.RestaurantGatewayImpl;

@Configuration
public class BeansConfig {

	@Bean
    public RestaurantGateway createRestaurantGateway() {
        final RestaurantGateway restaurantGateway = new RestaurantGatewayImpl();
        return restaurantGateway;
    }
	
}