package br.com.caelum.notafiscal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableAutoConfiguration
public class EatsNotaFiscalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatsNotaFiscalServiceApplication.class, args);
	}

}
