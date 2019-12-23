package pe.rpacheco.msPersonas.util;

import pe.rpacheco.msPersonas.dao.Persona;
import pe.rpacheco.msPersonas.dto.PersonaDto;

public class PersonaParse {

	public static PersonaDto daoToDto(Persona persona) {
		return new PersonaDto(persona.getId_persona(), 
				persona.getNombres(),
				persona.getApellidos(), 
				persona.getFecha_nacimiento(), 
				persona.getEstado());
	}
	
	public static Persona dtoToDao(PersonaDto persona) {
		return new Persona(persona.getIdPersona(),
				persona.getNombres(),
				persona.getApellidos(),
				persona.getFechaNacimiento(),
				persona.getEstado());
	}
	
}
