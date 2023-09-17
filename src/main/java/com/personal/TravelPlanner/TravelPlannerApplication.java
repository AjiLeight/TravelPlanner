package com.personal.TravelPlanner;

import com.personal.TravelPlanner.entity.User;
import com.personal.TravelPlanner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TravelPlannerApplication {


	public static void main(String[] args) {

		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
