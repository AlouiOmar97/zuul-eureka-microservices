package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	//Afficher la liste des tasks
	//http://localhost:0/tasks
	@Bean
	ApplicationRunner init(TaskRepository repository) {
		return args -> {
			Stream.of("arroser les plantes", "donne la viande a les chiens", "clean").forEach(nom -> {

				repository.save(new Task("2",nom));
			});
			repository.findAll().forEach(System.out::println);
		};

	}
}
