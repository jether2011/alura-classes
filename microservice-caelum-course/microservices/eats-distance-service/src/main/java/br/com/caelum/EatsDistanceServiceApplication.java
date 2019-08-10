package br.com.caelum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EatsDistanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatsDistanceServiceApplication.class, args);
	}

}
