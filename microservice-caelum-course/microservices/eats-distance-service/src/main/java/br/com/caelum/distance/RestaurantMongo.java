package br.com.caelum.distance;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
