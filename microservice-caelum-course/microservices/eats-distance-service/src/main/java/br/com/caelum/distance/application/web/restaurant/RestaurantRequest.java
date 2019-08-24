package br.com.caelum.distance.application.web.restaurant;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import br.com.caelum.distance.domain.restaurant.entities.Restaurant;

/**
 * 
 * @author micro8520
 *
 */
public class RestaurantRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	private Long id;
	@NotBlank 
	@NonNull
	@NotEmpty
	private String cep;
	@NonNull
	private Long cookId;
	
	public static Restaurant convertTo(RestaurantRequest request) {
		return new Restaurant(request.id, request.cep, true, request.cookId);
	}
}
