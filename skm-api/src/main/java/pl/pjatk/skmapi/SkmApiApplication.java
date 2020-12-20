package pl.pjatk.skmapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SkmApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkmApiApplication.class, args);
	}

}
