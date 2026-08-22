package ru.vluzhnykh.authbasics;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Log4j2
public class AuthbasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthbasicsApplication.class, args);
	}


	@PostConstruct
	public void logPassword() throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		var pass = passwordEncoder.encode("12345");
		log.info(String.format("Password: %s", pass));
	}
}
