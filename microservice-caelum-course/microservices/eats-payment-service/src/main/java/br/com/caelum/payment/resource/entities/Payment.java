package br.com.caelum.payment.resource.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Payment {

	public static enum Status {
		CREATED,
		CONFIRMED,
		CANCELED;
	}

	@Id
	@SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_id_seq", allocationSize = 1)
	@GeneratedValue(generator="payment_id_seq", strategy=GenerationType.SEQUENCE)
	private Long id;

	@NotNull @Positive
	private BigDecimal value;

	@NotBlank  @Size(max=100)
	private String name;

	@NotBlank  @Size(max=19)
	private String number;

	@NotBlank  @Size(max=7)
	private String expiration;
	
	@NotBlank @Size(min=3, max=3)
	private String code;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(nullable = false)
	private Long orderId;

	@Column(nullable = false)
	private Long paymentFormId;

}
