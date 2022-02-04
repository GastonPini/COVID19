package ar.com.flexia.cv19query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"ar.com.flexia"})
@EntityScan(basePackages = {"ar.com.flexia"})
@EnableJpaRepositories(basePackages = {"ar.com.flexia"})
public class Cv19QueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cv19QueryApplication.class, args);
	}

}