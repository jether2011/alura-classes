package br.com.caelum.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.caelum.payment.domain.PaymentObserver;
import br.com.caelum.payment.resource.PaymentObserverImpl;

@Configuration
public class InitConfig {

	@Bean
	public PaymentObserver<?> createObserver() {
		return (PaymentObserver<?>) new PaymentObserverImpl();
	}
	
}
