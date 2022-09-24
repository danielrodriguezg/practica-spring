package co.darodriguezg.practicaspringeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PracticaSpringEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaSpringEurekaApplication.class, args);
	}

}
