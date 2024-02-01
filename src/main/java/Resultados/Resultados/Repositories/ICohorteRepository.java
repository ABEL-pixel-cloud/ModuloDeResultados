package Resultados.Resultados.Repositories;

import Resultados.Resultados.Entity.Cohorte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICohorteRepository extends CrudRepository<Cohorte,Long> {
}
