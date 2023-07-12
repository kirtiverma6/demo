package com.kirti.demo;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/")
	public String greeting() {
		
		 LocalTime currentTime = LocalTime.now();
	        int hour = currentTime.getHour();
	        String greeting;

	        if (hour >= 0 && hour < 12) {
	            greeting = "Good morning";
	        } else {
	            greeting = "Good afternoon";
	        }
	        
	        return greeting + " Kirti Verma  Welcome to COMP367" ;
	}

}
