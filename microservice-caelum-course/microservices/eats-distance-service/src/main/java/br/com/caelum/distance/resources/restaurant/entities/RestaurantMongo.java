package br.com.caelum.distance.resources.restaurant.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.caelum.distance.domain.restaurant.entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantMongo {

	@Id
	private Long id;

	@NotBlank @Size(max=9)
	private String cep;
	
	@Indexed
	private Long cookId;

	public static final RestaurantMongo from(final Restaurant restaurant) {
		return new RestaurantMongo(restaurant.getId(), restaurant.getCep(), restaurant.getCookId());
	}
}
