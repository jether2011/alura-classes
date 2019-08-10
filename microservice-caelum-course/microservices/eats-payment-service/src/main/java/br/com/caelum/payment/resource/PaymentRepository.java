package br.com.caelum.payment.resource;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caelum.payment.resource.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
