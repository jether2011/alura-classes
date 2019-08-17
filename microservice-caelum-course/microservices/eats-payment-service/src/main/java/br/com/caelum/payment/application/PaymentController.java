package br.com.caelum.payment.application;

import static br.com.caelum.payment.application.Constants.PAYMENT_ID_DETAIL;
import static br.com.caelum.payment.application.Constants.RESOURCE;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.payment.application.exceptions.ResourceNotFoundException;
import br.com.caelum.payment.domain.PaymentObserver;
import br.com.caelum.payment.resource.OrderGateway;
import br.com.caelum.payment.resource.PaymentRepository;
import br.com.caelum.payment.resource.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(RESOURCE)
@AllArgsConstructor
@Slf4j
class PaymentController {

	private PaymentRepository paymentRepository;
	private OrderGateway orderGateway;
	private PaymentObserver<Payment> paymentObserver;

	@GetMapping
	public ResponseEntity<List<PaymentDto>> list() {
		return ResponseEntity
				.ok()
				.body(PaymentDto.from(paymentRepository.findAll()));
	}
	
	@GetMapping("/{id}")
	public PaymentDto detail(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new PaymentDto(payment);
	}

	@PostMapping
	public ResponseEntity<PaymentDto> creates(@RequestBody @Valid Payment payment, UriComponentsBuilder uriBuilder) {
		payment.setStatus(Payment.Status.CREATED);
		Payment saved = paymentRepository.save(payment);
		URI path = uriBuilder.path(PAYMENT_ID_DETAIL).buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(path).body(new PaymentDto(saved));
	}

	@PutMapping("/{id}")
	public PaymentDto confirmOrder(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		payment.setStatus(Payment.Status.CONFIRMED);
		paymentRepository.save(payment);
		
		tryConfirmPaidOrder(payment);
		trySendConfirmedPayment(payment);
		
		return new PaymentDto(payment);
	}

	@DeleteMapping("/{id}")
	public PaymentDto cancel(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		payment.setStatus(Payment.Status.CANCELED);
		paymentRepository.save(payment);
		return new PaymentDto(payment);
	}
	
	private void trySendConfirmedPayment(Payment payment) {
		
		try {
			paymentObserver.notifier(payment);
		} catch (Exception e) {
			log.error("Error to try send confirm payment! [{}]", e.getMessage());
		}		
	}

	private void tryConfirmPaidOrder(Payment payment) {
		try {
			orderGateway.paidOrderConfirm(payment.getId());
		} catch (Exception e) {
			log.error("Error to try confirm paid order! [{}]", e.getMessage());
		}		
	}
}