package com.hpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringBootLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLayerApplication.class, args);
	}
}
