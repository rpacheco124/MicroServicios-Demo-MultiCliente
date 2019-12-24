package pe.rpacheco.msEmpleados.util;

import pe.rpacheco.msEmpleados.dao.Empleado;
import pe.rpacheco.msEmpleados.dto.EmpleadoDto;

public class EmpleadoParse {

	public static EmpleadoDto daoToDto(Empleado empleado) {
		return new EmpleadoDto(empleado.getId_empleado(), 
				empleado.getId_persona(), 
				empleado.getCorreo(), 
				empleado.getTelefono(), 
				empleado.getEstado());
	}
	
	public static Empleado dtoToDao(EmpleadoDto empleado) {
		return new Empleado(empleado.getIdEmpleado(), 
				empleado.getIdPersona(), 
				empleado.getCorreo(), 
				empleado.getTelefono(), 
				empleado.getEstado());
	}

}
