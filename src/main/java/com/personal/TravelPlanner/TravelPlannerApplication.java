package com.personal.TravelPlanner;

import com.personal.TravelPlanner.entity.User;
import com.personal.TravelPlanner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class TravelPlannerApplication implements CommandLineRunner {

	private final UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		repository.save(new User(
//				"1",
//				"suhaib",
//				"vazin",
//				"suhaibvazin321@gmail.com",
//				"1234",
//				"user"
//		));
		User user =repository.findByEmail("suhaibvazin321@gmail.com").orElseThrow();
		System.out.println("Email is --------------------"+user.getEmail());
	}
}
