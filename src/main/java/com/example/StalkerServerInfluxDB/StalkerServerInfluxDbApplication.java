package com.example.StalkerServerInfluxDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class StalkerServerInfluxDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StalkerServerInfluxDbApplication.class, args);
	}

}
