package pe.rpacheco.msPersonas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rpacheco.msPersonas.dao.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
