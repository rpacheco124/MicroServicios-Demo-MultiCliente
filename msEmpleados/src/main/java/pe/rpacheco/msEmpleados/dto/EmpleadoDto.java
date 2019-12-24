package pe.rpacheco.msEmpleados.dto;

public class EmpleadoDto {

	private Long idEmpleado;
	private Long idPersona;
	private String correo;
	private String telefono;
	private Boolean estado;
	
	private String nombres;
	private String apellidos;

	public EmpleadoDto() {
		super();
	}

	public EmpleadoDto(Long idEmpleado, Long idPersona, String correo, String telefono, Boolean estado) {
		this.idEmpleado = idEmpleado;
		this.idPersona = idPersona;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	

}
