package pe.rpacheco.msEmpleados.dto;

public class PersonaResourceDto {
	
	private PersonaDto persona;

	public PersonaResourceDto(PersonaDto persona) {
		super();
		this.persona = persona;
	}

	public PersonaDto getPersona() {
		return persona;
	}

	public void setPersona(PersonaDto persona) {
		this.persona = persona;
	}
	
}
