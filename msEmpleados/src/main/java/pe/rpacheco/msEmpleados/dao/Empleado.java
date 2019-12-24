package pe.rpacheco.msEmpleados.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empleado;
	
	private Long id_persona;
	
	private String correo;
	private String telefono;
	private Boolean estado;
	
	public Empleado() {
		
	}

	public Empleado(Long id_empleado, Long id_persona, String correo, String telefono, Boolean estado) {
		this.id_empleado = id_empleado;
		this.id_persona = id_persona;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
	}
	
	public Long getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}
	public Long getId_persona() {
		return id_persona;
	}
	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
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
	
	
	
}
