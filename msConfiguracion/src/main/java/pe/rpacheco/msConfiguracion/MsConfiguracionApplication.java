package pe.rpacheco.msConfiguracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsConfiguracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConfiguracionApplication.class, args);
	}

}
