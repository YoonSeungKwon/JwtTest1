package yoon.test.jwtTest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JwtTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(JwtTest1Application.class, args);
	}

}
