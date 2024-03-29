package Resultados.Resultados.Repositories;

import Resultados.Resultados.Entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEstudianteRepository extends CrudRepository<Estudiante,Long> {

    Optional<Estudiante> findByidEstudiante(Long estudiante);
}