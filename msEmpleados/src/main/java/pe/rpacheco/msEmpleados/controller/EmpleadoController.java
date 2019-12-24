package pe.rpacheco.msEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rpacheco.msEmpleados.dto.EmpleadoDto;
import pe.rpacheco.msEmpleados.service.EmpleadoService;

@RestController
@RequestMapping(path = "/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping("/")
	public List<EmpleadoDto> getAll(){
		return empleadoService.getAll();
	}
	
	@PostMapping("/save")
	public EmpleadoDto save(@RequestBody EmpleadoDto empleado, @RequestHeader("Authorization") String token) throws Exception {
		System.out.println(token);
		return empleadoService.save(empleado, token);
	}
	
}
