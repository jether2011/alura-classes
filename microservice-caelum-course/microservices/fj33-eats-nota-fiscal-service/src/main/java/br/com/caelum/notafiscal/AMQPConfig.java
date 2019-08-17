package br.com.caelum.notafiscal;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

import br.com.caelum.notafiscal.AMQPConfig.PaymentConsumer;

@EnableBinding(PaymentConsumer.class)
@Configuration
public class AMQPConfig {

	public static interface PaymentConsumer {
		String PAYMENTS_CONFIRMED = "paymentsConfirmed";
		
		@Input
		SubscribableChannel paymentsConfirmed();		
	}
	
}
