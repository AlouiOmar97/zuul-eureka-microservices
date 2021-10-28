package tn.esprit;


import java.util.stream.Stream; 

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import tn.esprit.model.ImageModel;
import tn.esprit.repository.ImageRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class ImageUploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageUploadServiceApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init(ImageRepository repository) {
		return args -> {
			Stream.of("hello", "asslema", "hii").forEach(nom -> {
				repository.save(new ImageModel(nom,nom));
			});
			repository.findAll().forEach(System.out::println);
		};
}
}
