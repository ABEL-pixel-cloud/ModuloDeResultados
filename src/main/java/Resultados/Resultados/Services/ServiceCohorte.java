package Resultados.Resultados.Services;


import Resultados.Resultados.Entity.Cohorte;
import Resultados.Resultados.Entity.Estudiante;
import Resultados.Resultados.Repositories.IAspiranteRepository;
import Resultados.Resultados.Repositories.ICohorteRepository;
import Resultados.Resultados.Repositories.IDocumentacionRepository;
import Resultados.Resultados.Repositories.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceCohorte {


    private IEstudianteRepository estudianteRepository;
    private IAspiranteRepository aspiranteRepository;
    private IDocumentacionRepository documentacionRepository;

    private ICohorteRepository cohorteRepository;

    @Autowired
    public ServiceCohorte(IEstudianteRepository estudianteRepository,
                          IAspiranteRepository aspiranteRepository,
                          IDocumentacionRepository documentacionRepository,
                          ICohorteRepository cohorteRepository) {
        this.estudianteRepository = estudianteRepository;
        this.aspiranteRepository = aspiranteRepository;
        this.documentacionRepository = documentacionRepository;
        this.cohorteRepository = cohorteRepository;
    }








    public void CreacionDeCohorte(List<Estudiante> estudiantes, String cohorte) {

        Cohorte cohorteObjeto = Cohorte.builder()
                .cohorte(cohorte)
                .build();


        cohorteRepository.save(cohorteObjeto);

        // Itera sobre la lista de estudiantes
        for (Estudiante estudiante : estudiantes) {
            // Obtén el ID del estudiante actual
            Long idEstudiante = estudiante.getIdEstudiante();

            // Busca el estudiante en el repositorio
            Optional<Estudiante> estudianteEncontrado = estudianteRepository.findById(idEstudiante);

            // Si el estudiante se encuentra en la base de datos
            if (estudianteEncontrado.isPresent()) {
                // Asigna la cohorte al estudiante y guarda el cambio
                Estudiante estudianteActualizado = estudianteEncontrado.get();
                estudianteActualizado.setCohorte(cohorteObjeto);
                estudianteRepository.save(estudianteActualizado);
            }
        }
    }

}
