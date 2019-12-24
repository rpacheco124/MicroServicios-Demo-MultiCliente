package pe.rpacheco.msEmpleados.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import pe.rpacheco.msEmpleados.dto.PersonaDto;

@FeignClient("personas")
public interface PersonaClient {

	@PostMapping(path = "/personas/save", produces = "application/json")
	public PersonaDto save(@RequestBody PersonaDto persona, @RequestHeader("Authorization") String token);
	
}
