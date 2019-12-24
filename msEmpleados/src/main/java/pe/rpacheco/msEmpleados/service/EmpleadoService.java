package pe.rpacheco.msEmpleados.service;

import java.util.List;

import pe.rpacheco.msEmpleados.dto.EmpleadoDto;

public interface EmpleadoService {

	public List<EmpleadoDto> getAll();
	public EmpleadoDto save(EmpleadoDto empleado, String token) throws Exception;
	public EmpleadoDto findById(Long id) throws Exception;
	
}
