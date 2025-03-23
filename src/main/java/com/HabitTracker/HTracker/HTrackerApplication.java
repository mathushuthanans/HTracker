package com.HabitTracker.HTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 * *
 * Here the reason to use the @ComponentScan
 * 
 */
@SpringBootApplication
@ComponentScan("com.HabitTracker.HTracker")
public class HTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HTrackerApplication.class, args);
	}

}
