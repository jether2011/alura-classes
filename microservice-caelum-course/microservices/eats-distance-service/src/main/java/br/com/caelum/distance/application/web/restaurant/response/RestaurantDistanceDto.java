package br.com.caelum.distance.application.web.restaurant.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDistanceDto {

	private Long restauranteId;

	private BigDecimal distance;

}
