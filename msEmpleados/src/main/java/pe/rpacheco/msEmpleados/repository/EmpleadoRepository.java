package pe.rpacheco.msEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.rpacheco.msEmpleados.dao.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
