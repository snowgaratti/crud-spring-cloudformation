package br.com.snowgaratti;

import br.com.snowgaratti.crud.config.DynamoDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnowgarattiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowgarattiApplication.class, args);
	}

}
