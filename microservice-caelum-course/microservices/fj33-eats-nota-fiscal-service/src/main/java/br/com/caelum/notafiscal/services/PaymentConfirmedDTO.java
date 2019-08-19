package br.com.caelum.notafiscal.services;

import java.io.Serializable;

public final class PaymentConfirmedDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long paymentId;
	private long orderId;
	
	public PaymentConfirmedDTO() {}
	
	public long getPaymentId() {
		return paymentId;
	}
	
	public long getOrderId() {
		return orderId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [ paymentId=").append(paymentId).append(", orderId=").append(orderId)
				.append("]");
		return builder.toString();
	}
	
}
