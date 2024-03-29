package Resultados.Resultados.Controllers;

import Resultados.Resultados.Dtos.DocumentosDto;
import Resultados.Resultados.Dtos.EstadoDocumentosDto;
import Resultados.Resultados.Dtos.ReciveCohortes;
import Resultados.Resultados.Dtos.ReciveDocumentosDto;


import Resultados.Resultados.Entity.Documentacion;
import Resultados.Resultados.Exceptions.ResponseMessage;

import Resultados.Resultados.Services.CredencialesEstudiante;
import Resultados.Resultados.Services.DocumentoService;
import Resultados.Resultados.Services.EstudianteService;
import Resultados.Resultados.Services.ServiceCohorte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/documentos/")
public class DocumentosController {


    private DocumentoService documentoService;
    private CredencialesEstudiante aspirante;

    private EstudianteService estudianteService;
    private ServiceCohorte serviceCohorte;
    @Autowired
    public DocumentosController(DocumentoService documentoService,
                                CredencialesEstudiante aspirante,
                                EstudianteService estudianteService,
                                ServiceCohorte serviceCohorte) {
        this.documentoService = documentoService;
        this.aspirante = aspirante;
        this.estudianteService = estudianteService;
        this.serviceCohorte=serviceCohorte;
    }


    @PostMapping("/cargar")
    public ResponseEntity<ResponseMessage> cargarArchivo(@RequestParam("acta") MultipartFile acta,@RequestParam("documento") MultipartFile documento,
                                                              @RequestParam("cedulaAspirante") Long cedulaAspirante)
            throws IOException {

        documentoService.store(acta,documento,cedulaAspirante);
        return ResponseEntity.status(HttpStatus.OK).
                body(new ResponseMessage("archivo subido correctamente"));

    }

    @PostMapping("/estadoDocumento")
    public ResponseEntity<List<EstadoDocumentosDto>> estadoDocumento(@RequestBody ReciveDocumentosDto request)  {
        List<EstadoDocumentosDto> estadoDocumentacionList = documentoService.estadoDocumentacion(request.getIdAspirante(), request.getEstado());
       /* aspirante.enviarCredenciales(request.getIdAspirante()); */
        estudianteService.crearEstudiantes(request.getIdAspirante());
        return ResponseEntity.ok(estadoDocumentacionList);
    }
    @PostMapping("/asignacionCohorte")
    public void cohorte(@RequestBody ReciveCohortes request)  {
          serviceCohorte.CreacionDeCohorte(request.getIdEstudiante(),request.getCohorte());
          aspirante.enviarCredencialesEstudiante(request.getIdEstudiante());

    }

    @GetMapping("cedula/{id}")
    public ResponseEntity<byte[]> descargarArchivo(@PathVariable UUID id) throws FileNotFoundException {
        Documentacion documentacion=documentoService.getfile(id).get();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE,  documentacion.getTipoDocumentocedula())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +  documentacion.getDocumentoCedula() + "\"")
                .body(documentacion.getDataDocumentoCedula());

    }
    @GetMapping("acta/{id}")
    public ResponseEntity<byte[]> descargarArchivoacta(@PathVariable UUID id) throws FileNotFoundException {
        Documentacion documentacion=documentoService.getfile(id).get();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, documentacion.getTipoDocumentoacta())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentacion.getDocumentoActa() + "\"")
                .body(documentacion.getDataDocumentoActa());

    }




    @GetMapping("/documento")
    public ResponseEntity<List<DocumentosDto>> listarArchivos(){
        List<DocumentosDto> documento=documentoService.getAllFiles();
        if (documento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Devuelve 204 si no hay contenido
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(documento);
        }
    }


}
