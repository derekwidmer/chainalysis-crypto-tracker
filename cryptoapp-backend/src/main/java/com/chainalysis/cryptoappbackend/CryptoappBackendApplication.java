package com.chainalysis.cryptoappbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoappBackendApplication.class, args);
	}

}

