package Resultados.Resultados.Services;


import Resultados.Resultados.Entity.Aspirante;
import Resultados.Resultados.Entity.Documentacion;
import Resultados.Resultados.Entity.Estudiante;
import Resultados.Resultados.Repositories.IAspiranteRepository;
import Resultados.Resultados.Repositories.IDocumentacionRepository;
import Resultados.Resultados.Repositories.IEstudianteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteService {

    private IDocumentacionRepository documentacionRepository;
    private IAspiranteRepository aspiranteRepository;
    private IEstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(IDocumentacionRepository documentacionRepository,
                             IAspiranteRepository aspiranteRepository,
                             IEstudianteRepository estudianteRepository) {
        this.documentacionRepository = documentacionRepository;
        this.aspiranteRepository = aspiranteRepository;
        this.estudianteRepository = estudianteRepository;
    }




    public void crearEstudiantes(List<Aspirante> idaspirante) {

        for (Aspirante aspirante : idaspirante) {
            // Obtener el ID del aspirante actual
            Long idAspirante = aspirante.getIdaspirante();

            // Buscar el aspirante en la base de datos por su ID
            Optional<Aspirante> aspiranteOptional = aspiranteRepository.findById(idAspirante);

            // Verificar si el aspirante existe
            if (aspiranteOptional.isPresent()) {
                Aspirante aspiranteEncontrado = aspiranteOptional.get();


                Optional<Documentacion> documentacion = documentacionRepository.findByAspirante(aspirante);
                if (documentacion.isPresent() && documentacion.get().getEstadoDocumentos()) {
                    Estudiante estudiante1= Estudiante.builder()
                            .nombre(aspiranteEncontrado.getNombresCompletos())
                            .cedula(String.valueOf(aspiranteEncontrado.getDocumento()))
                            .programa(aspiranteEncontrado.getPrograma())
                            .aspirante(aspiranteEncontrado)
                            .build();

                    estudianteRepository.save(estudiante1);

                } else {
                    throw new RuntimeException("no se puede guardar el estudiante");
                }

            } else {
                throw new EntityNotFoundException("No se encontró el aspirante con ID: " + idAspirante);
            }
        }
    }





}
