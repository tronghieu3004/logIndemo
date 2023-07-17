package com.utm.jpacrud;

import com.utm.jpacrud.Security.JWTUltil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JpacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacrudApplication.class, args);
	}

}
