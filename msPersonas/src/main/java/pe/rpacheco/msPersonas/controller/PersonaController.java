package pe.rpacheco.msPersonas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msPersonas.dto.PersonaDto;
import pe.rpacheco.msPersonas.service.PersonaService;

@RestController
@RequestMapping(path = "/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public List<PersonaDto> getAll() {
		return personaService.getAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<PersonaDto> save(@RequestBody PersonaDto persona) {
		//return personaService.save(persona);
		return new ResponseEntity<PersonaDto>(personaService.save(persona), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonaDto> findById(@PathVariable("id") Long id) throws Exception {
		//return personaService.findById(id);
		return new ResponseEntity<PersonaDto>(personaService.findById(id), HttpStatus.OK);
	}
	
}
