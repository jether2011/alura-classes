package br.com.caelum.payment.application;

import java.io.Serializable;

public final class PaymentConfirmedDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private final long paymentId;
	private final long orderId;
	
	private PaymentConfirmedDTO(final long paymentId, final long orderId) {
		this.paymentId = paymentId;
		this.orderId = orderId;
	}
	
	public static PaymentConfirmedDTO of(final long paymentId, final long orderId) {
		return new PaymentConfirmedDTO(paymentId, orderId);
	}

	public long getPaymentId() {
		return paymentId;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
}
