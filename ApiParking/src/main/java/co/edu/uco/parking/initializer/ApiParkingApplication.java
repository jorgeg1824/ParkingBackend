package co.edu.uco.parking.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "co.edu.uco.parking" })
@SpringBootApplication
public class ApiParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiParkingApplication.class, args);
	}

}
