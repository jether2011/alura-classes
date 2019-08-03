package br.com.caelum.distance;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Restaurant {

	@Id
	private Long id;

	@NotBlank @Size(max=9)
	private String cep;

	@Indexed
	private Boolean approved;
	
	@Indexed
	private Long cookId;
}
