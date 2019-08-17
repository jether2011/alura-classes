package br.com.caelum.payment.domain;

public interface PaymentObserver<T> {

	void notifier(T t);
	
}
