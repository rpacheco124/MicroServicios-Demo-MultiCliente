package pe.rpacheco.msPersonas.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rpacheco.msPersonas.dao.Persona;
import pe.rpacheco.msPersonas.dto.PersonaDto;
import pe.rpacheco.msPersonas.repository.PersonaRepository;
import pe.rpacheco.msPersonas.util.PersonaParse;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	@Override
	public List<PersonaDto> getAll() {
		return personaRepository.findAll().stream().map(p -> PersonaParse.daoToDto(p)).collect(Collectors.toList());
	}

	@Override
	public PersonaDto save(PersonaDto persona) {
		if (persona.getIdPersona() == null || persona.getIdPersona() == 0) {
			persona.setEstado(true);
		}
		return PersonaParse.daoToDto(personaRepository.save(PersonaParse.dtoToDao(persona)));
	}

	@Override
	public PersonaDto findById(Long id) throws Exception {
		Persona p = null;
		try {
			p = personaRepository.findById(id).get();
		} catch (NoSuchElementException e) {
		}
		if (p == null) {
			throw new Exception("La persona con id [" + id + "] no existe!");
		}
		return PersonaParse.daoToDto(p);
	}

}
