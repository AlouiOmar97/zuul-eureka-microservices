package com.esprit.microservice;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class BlogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServiceApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init(BlogRepository repository) {
		return args -> {
			Stream.of("train dog", "feed dog", "plant fruits").forEach(titre -> {
				repository.save(new Blog(titre));
			});
			repository.findAll().forEach(System.out::println);
		};

	}
	
	
	@RestController
	class ServiceInstanceRestController{
		@Autowired
		private DiscoveryClient discoveryClient;
		
		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> ServiceInstancesByApplicationName(
				@PathVariable String applicationName){
			return this.discoveryClient.getInstances(applicationName);
		}
	}
	
}
