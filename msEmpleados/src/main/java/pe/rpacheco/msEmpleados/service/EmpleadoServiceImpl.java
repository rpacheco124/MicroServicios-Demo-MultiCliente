package pe.rpacheco.msEmpleados.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rpacheco.msEmpleados.client.PersonaClient;
import pe.rpacheco.msEmpleados.dao.Empleado;
import pe.rpacheco.msEmpleados.dto.EmpleadoDto;
import pe.rpacheco.msEmpleados.dto.PersonaDto;
import pe.rpacheco.msEmpleados.repository.EmpleadoRepository;
import pe.rpacheco.msEmpleados.security.AuthTokenContext;
import pe.rpacheco.msEmpleados.util.EmpleadoParse;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	PersonaClient personaClient;
	
	@Override
	public List<EmpleadoDto> getAll() {
		return empleadoRepository.findAll()
				.stream()
				.map(e -> EmpleadoParse.daoToDto(e))
				.collect(Collectors.toList());
	}

	@Override
	public EmpleadoDto save(EmpleadoDto empleado) throws Exception {
		if (empleado.getIdEmpleado() == null || empleado.getIdEmpleado() == 0) {
			if (empleado.getNombres().isEmpty()) {
				throw new Exception("Se debe de ingresar el nombre del empleado!");
			}
			PersonaDto pSave = new PersonaDto(empleado.getNombres(), empleado.getApellidos());
			PersonaDto persona = personaClient.save(pSave, AuthTokenContext.getToken());
			
			if (persona.getIdPersona() == null) {
				throw new Exception("Ocurrio un error con el servicio de Personas");
			}
			
			empleado.setIdPersona(persona.getIdPersona());
			empleado.setEstado(true);
		}
		return EmpleadoParse.daoToDto(empleadoRepository.save(EmpleadoParse.dtoToDao(empleado)));
	}

	@Override
	public EmpleadoDto findById(Long id) throws Exception {
		Empleado e = null;
		try {
			e = empleadoRepository.findById(id).get();
		} catch (NoSuchElementException ex) { }
		
		if (e == null) {
			throw new Exception("El Empleado con id [" + id + "] no existe!");
		}
		return EmpleadoParse.daoToDto(e);
	}

}
