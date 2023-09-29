package com.personal.TravelPlanner;

import com.personal.TravelPlanner.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@RequiredArgsConstructor
@EnableWebMvc
@EnableMongoRepositories
public class TravelPlannerApplication implements CommandLineRunner{
	private final TokenRepository tokenRepository;


	public static void main(String[] args) {

		SpringApplication.run(TravelPlannerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		tokenRepository.save(Token
//				.builder()
//				.token("helloworldhowareyou")
//				.user(User.builder().id("650720c221d8db6c685c4f42").build())
//				.build());
	}
}
