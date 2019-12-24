package pe.rpacheco.msPersonas.service;

import java.util.List;

import pe.rpacheco.msPersonas.dto.PersonaDto;

public interface PersonaService {

	public List<PersonaDto> getAll();
	public PersonaDto save(PersonaDto persona);
	public PersonaDto findById(Long id) throws Exception;
	
}
