package br.com.caelum.distance;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class RestaurantDistanceDto {

	private Long restauranteId;

	private BigDecimal distance;

}
