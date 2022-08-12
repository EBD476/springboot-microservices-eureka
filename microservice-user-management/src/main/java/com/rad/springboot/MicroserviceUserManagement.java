package com.rad.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rad.springboot.model.User;
import com.rad.springboot.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceUserManagement implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserManagement.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// User user = new User();
		// user.setUsername("Springboot");
		// user.setPassword(new BCryptPasswordEncoder().encode("SpringBoot"));
		// userRepository.save(user);
		
	}

}
