package br.com.caelum.configs;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

import br.com.caelum.configs.PaymentAMQPConfig.PaymentProducer;

@EnableBinding(PaymentProducer.class)
@Configuration
public class PaymentAMQPConfig {

	public static interface PaymentProducer {
		String PAYMENTS_CONFIRMED = "paymentsConfirmed";
		
		@Output
		MessageChannel paymentsConfirmed();
	}
	
}
