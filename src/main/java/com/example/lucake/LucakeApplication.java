package com.example.lucake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
//@EnableAspectJAutoProxy
@EnableCaching
@SpringBootApplication
public class LucakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucakeApplication.class, args);
	}

}
