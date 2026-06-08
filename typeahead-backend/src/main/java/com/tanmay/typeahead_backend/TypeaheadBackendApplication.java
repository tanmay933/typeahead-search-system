package com.tanmay.typeahead_backend;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
public class TypeaheadBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypeaheadBackendApplication.class, args);
	}

}
