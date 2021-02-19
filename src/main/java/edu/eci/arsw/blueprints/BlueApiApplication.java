package edu.eci.arsw.blueprints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.blueprints"})
public class BlueApiApplication {

	public static void main(String[] args) {
		System.out.println("maiiiiiin");
		SpringApplication.run(BlueApiApplication.class, args);
	}
}
