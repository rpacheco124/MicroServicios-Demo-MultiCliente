package pe.rpacheco.msdemorest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msdemorest.entity.PersonaEntity;
import pe.rpacheco.msdemorest.repository.PersonaRepository;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/personas")
	public List<PersonaEntity> getPersonas(){
		return personaRepository.findAll();
	}

}
