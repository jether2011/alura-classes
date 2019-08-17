package br.com.caelum.notafiscal.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import br.com.caelum.notafiscal.AMQPConfig.PaymentConsumer;
import br.com.caelum.notafiscal.pedido.PedidoDto;
import br.com.caelum.notafiscal.pedido.PedidoRestClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ProcessadorDePagamentos {

	private GeradorDeNotaFiscal notaFiscal;
	private PedidoRestClient pedidos;

	@StreamListener(PaymentConsumer.PAYMENTS_CONFIRMED)
	public void processaPagamento(PaymentConfirmedDTO payment) {
		log.info("Received: {}", payment);
		tryRetrieveOrderAndGenerateNF(payment); 
	}

	private void tryRetrieveOrderAndGenerateNF(PaymentConfirmedDTO payment) {
		try {
			PedidoDto pedido = pedidos.detalhaPorId(payment.getOrderId());
			String nota = notaFiscal.geraNotaPara(pedido);
			System.out.println(nota);
		} catch (Exception e) {
			log.error("Error to consuming monolith! [{}]", e.getMessage());
		}		
	}
}
