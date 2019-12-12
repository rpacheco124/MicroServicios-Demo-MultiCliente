package pe.rpacheco.msSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msSeguridad.entity.Usuario;
import pe.rpacheco.msSeguridad.repository.UsuarioRepository;

@SpringBootApplication
@EnableAuthorizationServer
@EnableDiscoveryClient
@RestController
public class MsSeguridadApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MsSeguridadApplication.class, args);
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping(value="/createUser")
	public ResponseEntity<?> signup(@RequestBody Usuario user) {
		user.setEstado(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
