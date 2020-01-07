package pe.rpacheco.msEmpleados.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msEmpleados.dto.EmpleadoDto;
import pe.rpacheco.msEmpleados.service.EmpleadoService;

@RestController
@RequestMapping(path = "/")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("")
	public List<EmpleadoDto> getAll() {
		logger.info("Antes GET getAll Empleados");
		return empleadoService.getAll();
	}

	@PostMapping("/save")
	public EmpleadoDto save(@RequestBody EmpleadoDto empleado) throws Exception {
		logger.info("Antes POST save Empleados");
		return empleadoService.save(empleado);
	}

}
