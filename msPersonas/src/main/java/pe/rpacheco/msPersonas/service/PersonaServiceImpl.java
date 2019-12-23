package pe.rpacheco.msPersonas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void save(PersonaDto persona) {
		personaRepository.save(PersonaParse.dtoToDao(persona));
	}

	@Override
	public PersonaDto findById(Long id) {
		return PersonaParse.daoToDto(personaRepository.findById(id).get());
	}

}
