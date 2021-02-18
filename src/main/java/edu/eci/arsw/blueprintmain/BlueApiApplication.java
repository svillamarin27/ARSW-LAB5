package edu.eci.arsw.blueprintmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.blueprintmain"})
public class BlueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueApiApplication.class, args);
	}
}
