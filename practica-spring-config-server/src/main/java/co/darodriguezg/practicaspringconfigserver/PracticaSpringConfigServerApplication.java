package co.darodriguezg.practicaspringconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PracticaSpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaSpringConfigServerApplication.class, args);
	}

}
