package pe.rpacheco.msEmpleados.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msEmpleados.entity.PersonaEntity;
import pe.rpacheco.msEmpleados.repository.PersonaRepository;

@RestController
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/personas")
	public List<PersonaEntity> getPersonas(ServletRequest request) {
		return personaRepository.findAll();
	}
	
}
