package pe.rpacheco.msPersonas.service;

import java.util.List;

import pe.rpacheco.msPersonas.dto.PersonaDto;

public interface PersonaService {

	public List<PersonaDto> getAll();
	public void save(PersonaDto persona);
	public PersonaDto findById(Long id);
	
}
