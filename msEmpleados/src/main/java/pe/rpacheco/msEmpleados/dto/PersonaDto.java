package pe.rpacheco.msEmpleados.dto;

import java.util.Date;

public class PersonaDto {

	private Long idPersona;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private Boolean estado;
	
	public PersonaDto() {
		
	}
	
	public PersonaDto(Long idPersona, String nombres, String apellidos, Date fechaNacimiento, Boolean estado) {
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
	}

	public PersonaDto(String nombres, String apellidos) {
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
}
