package pe.rpacheco.msdemorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rpacheco.msdemorest.entity.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

}
