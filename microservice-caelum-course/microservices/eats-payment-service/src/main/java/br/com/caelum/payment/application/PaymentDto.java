package br.com.caelum.payment.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.payment.resource.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class PaymentDto {

	private Long id;
	private BigDecimal value;
	private String name;
	private String number;
	private String expiration;
	private String code;
	private Payment.Status status;
	private Long paymentFormId;
	private Long orderId;

	public PaymentDto(Payment p) {
		this(p.getId(), p.getValue(), p.getName(), p.getNumber(), p.getExpiration(), p.getCode(), p.getStatus(), p.getPaymentFormId(), p.getOrderId());
	}

	public final static List<PaymentDto> from(List<Payment> payments) {
		return payments.stream().map(PaymentDto::new).collect(Collectors.toList());
	}
}
