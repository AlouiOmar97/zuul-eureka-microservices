package com.esprit.microservice;

import java.util.stream.Stream; 

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}
	
	//Afficher la liste des employes
	//http://localhost:0/employes
	@Bean
	ApplicationRunner init(EmployeRepository repository) {
		return args -> {
			Stream.of("khalil.missaoui1@esprit.tn", "mohamedfarouk.benakacha@esprit.tn", "dalirecardo@gmail.com").forEach(nom -> {
				repository.save(new Employe(nom,nom));
			});
			repository.findAll().forEach(System.out::println);
		};

	}
}
