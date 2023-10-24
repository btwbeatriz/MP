package br.com.fiap.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpApplication.class, args);
	}

}
