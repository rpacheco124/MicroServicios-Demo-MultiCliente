package pe.rpacheco.msSeguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableDiscoveryClient
@RestController
public class MsSeguridadApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MsSeguridadApplication.class, args);
	}

}
