package br.com.caelum.distance.domain.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Restaurant {

	private Long id;
	private String cep;
	private Boolean approved;
	private Long cookId;
}
