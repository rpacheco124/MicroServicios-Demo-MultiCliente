package pe.rpacheco.msPersonas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msPersonas.dto.PersonaDto;
import pe.rpacheco.msPersonas.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;

	@GetMapping("/personas")
	public List<PersonaDto> getAll() {
		return personaService.getAll();
	}
	
}
