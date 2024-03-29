
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
public class CredencialesEstudiante {



    private IDocumentacionRepository documentacionRepository;
    private EmailServiceImpl emailService;

    private IAspiranteRepository aspiranteRepository;
    private IEstudianteRepository estudianteRepository;

    @Autowired
    public CredencialesEstudiante(IDocumentacionRepository documentacionRepository,
                                  EmailServiceImpl emailService,
                                  IAspiranteRepository aspiranteRepository,
                                  IEstudianteRepository estudianteRepository) {
        this.documentacionRepository = documentacionRepository;
        this.emailService = emailService;
        this.aspiranteRepository = aspiranteRepository;
        this.estudianteRepository = estudianteRepository;
    }




    public void enviarCredenciales(List<Aspirante> idaspirantes) {

        for (Aspirante aspirante : idaspirantes) {
            // Obtener el ID del aspirante actual
            Long idAspirante = aspirante.getIdaspirante();

            // Buscar el aspirante en la base de datos por su ID
            Optional<Aspirante> aspiranteOptional = aspiranteRepository.findById(idAspirante);

            // Verificar si el aspirante existe
            if (aspiranteOptional.isPresent()) {
                Aspirante aspiranteEncontrado = aspiranteOptional.get();

                // Verificar si el correo del aspirante no es nulo
                if (aspiranteEncontrado.getCorreo() != null) {
                    Optional<Documentacion> documentacion = documentacionRepository.findByAspirante(aspirante);
                    if (documentacion.isPresent() && documentacion.get().getEstadoDocumentos()) {
                        String email=aspiranteEncontrado.getCorreo();
                        // Enviar correo electrónico con las credenciales
                        emailService.sendEmail(new String[]{email}, "Estas son tus credenciales", "SGJSGJAHDKSAD");
                        System.out.println("enviar correo");

                    }else {
                        throw new RuntimeException("no se puede enviar el correo");
                    }
                } else {
                    throw new RuntimeException("La dirección de correo electrónico del aspirante es nula");
                }
            } else {
                throw new EntityNotFoundException("No se encontró el aspirante con ID: " + idAspirante);
            }
        }
    }

    public void enviarCredencialesEstudiante(List<Estudiante> estudiantes) {

        for (Estudiante estudiante : estudiantes) {
            // Obtener el ID del aspirante actual
            Long idEstudiante= estudiante.getIdEstudiante();

            // Buscar el estudiante en la base de datos por su ID
            Optional<Estudiante> estudianteOptional = estudianteRepository.findByidEstudiante(idEstudiante);

            // Verificar si el aspirante existe
            if (estudianteOptional.isPresent()) {
                Estudiante estudianteEncontrado = estudianteOptional.get();

                // Verificar si el correo del aspirante no es nulo
                if (estudianteEncontrado.getAspirante().getCorreo() != null && estudianteEncontrado.getAspirante().getPrograma().equals("Desarrollo Back-End")) {
                        String email=estudianteEncontrado.getAspirante().getCorreo();
                        String cohorte=estudianteEncontrado.getCohorte().getCohorte();
                        String nombre = estudianteEncontrado.getNombre();

                    String message = "<html><body>" +

                            "<p style='font-size: 14px;'> Hola  "+ "<b>" + nombre +"</b>" + "<br>" + "<br>" + "<br>" +
                            " Espero que estés bien. Nos complace mucho que seas parte de  nuestra <b>COHORTE</b> "+cohorte+"." + "<br>" + "<br>" +
                            " Para que puedas integrarte completamente y participar en todas nuestras actividades, aquí te proporciono tus credenciales:  " + "<br>" + "<br>" +

                       /*
                            "<div style=\"text-align: center;\"  >" +
                            "<h4 style='font-size: 14px;'>¿Qué encontrarás en el acta de compromiso adjunta?</h4><br>"+
                            "</div>"+
                            */

                            "<ul style='font-size: 14px;'>"+
                            "<li><b>Grupo de WhatsApp:</b> <a href='[Enlace al grupo de WhatsApp]'>  Enlace al grupo de WhatsApp</a></li>" + "<br>" + "<br>" +

                            "<li><b>Grupo de Slack:</b>  <a href='[Enlace al grupo de Slack]'> Enlace al grupo de Slack</a></li>" + "<br>"+ "<br>" +

                            "<li><b>Correo de Makaia:</b> <a href='[Correo electrónico asociado a Makaia]'>Correo electrónico asociado a Makaia</a></li> " + "<br>" + "<br>" +
                            "</ul>"+


                            " Por favor, asegúrate de unirte a estos grupos lo antes posible para que puedas comenzar a conectarte con el resto de la comunidad y acceder a toda la información relevante "+"<br>"+
                            "para tu participación en la cohorte."+"<br>"+
                            "<b>FELICITACIONES y BIENVENIDO (A)</b> al Bootcamp de MAKAIA." +"<br>"+"<br"+
                            " Si tienes alguna pregunta o necesitas ayuda para unirte a alguno de estos grupos, no dudes en contactarnos  " +"<br>"+"<br>"+
                            "¡Esperamos verte pronto en nuestras plataformas!   " + "<b>"+"<br>"+"<br>"+



                            "</p>"+

                            "</body></html>";

                    // Enviar correo electrónico con las credenciales
                        emailService.sendEmail(new String[]{email}, "Estas son tus credenciales para "+estudianteEncontrado.getAspirante().getPrograma(), message);
                        System.out.println("enviar correo");

                    }
                else if (estudianteEncontrado.getAspirante().getCorreo() != null && estudianteEncontrado.getAspirante().getPrograma().equals("Desarrollo Front-End")) {

                    String email=estudianteEncontrado.getAspirante().getCorreo();
                    // Enviar correo electrónico con las credenciales
                    emailService.sendEmail(new String[]{email}, "Estas son tus credenciales", "credenciales para desarrollador Front-End");
                    System.out.println("enviar correo");

                } else if(estudianteEncontrado.getAspirante().getCorreo() != null && estudianteEncontrado.getAspirante().getPrograma().equals("Analista De Datos")){
                    String email=estudianteEncontrado.getAspirante().getCorreo();
                    // Enviar correo electrónico con las credenciales
                    emailService.sendEmail(new String[]{email}, "Estas son tus credenciales", "credenciales para Analista De Datos");
                    System.out.println("enviar correo");

                }else {
                    throw new RuntimeException("no se puede enviar el correo");
                }
                } else {
                    throw new RuntimeException("La dirección de correo electrónico del estudiante es nula");
                }
            }

        }

}




