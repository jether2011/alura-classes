package br.com.caelum.payment.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(url = "${order.service.url}", name = "order")
public interface OrderGateway {

	@PutMapping("/orders/{id}/paid")
	void paidOrderConfirm(@PathVariable("id") Long id);
	
}
