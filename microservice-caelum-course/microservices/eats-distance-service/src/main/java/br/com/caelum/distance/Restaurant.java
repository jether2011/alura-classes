package br.com.caelum.distance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Restaurant {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank @Size(max=18)
	private String cnpj;
	
	@NotBlank @Size(max=255)
	private String name;
	
	@Size(max=1000)
	private String description;

	@NotBlank @Size(max=9)
	private String cep;

	@NotBlank @Size(max=300)
	private String address;

	@Positive
	private BigDecimal deliveryFee;
	
	@Positive @Min(10) @Max(180)
	private Integer minimalDeliveryTime;
	
	@Positive @Min(10) @Max(180)
	private Integer maximumDeliveryTime;
	
	private Boolean approved;

	@Column(nullable = false)
	private Long cookId;
}
