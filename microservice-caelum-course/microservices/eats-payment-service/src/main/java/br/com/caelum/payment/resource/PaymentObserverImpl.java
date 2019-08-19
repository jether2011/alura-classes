package br.com.caelum.payment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;

import br.com.caelum.configs.PaymentAMQPConfig.PaymentProducer;
import br.com.caelum.payment.application.PaymentConfirmedDTO;
import br.com.caelum.payment.domain.PaymentObserver;
import br.com.caelum.payment.resource.entities.Payment;

public class PaymentObserverImpl implements PaymentObserver<Payment> {

	@Autowired
	private PaymentProducer paymentSource;

	@Override
	public void notifier(Payment payment) {
		paymentSource.paymentsConfirmed().send(
				MessageBuilder.withPayload(PaymentConfirmedDTO.of(payment.getId(), payment.getOrderId())).build());
	}

}
