package Resultados.Resultados.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Documentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentacion;


    @Column(length = 100)
    private String Tipo_Documento;

    @Column(length = 100)
    private String Estado_Documento;

    @Column(length = 100)
    private String DocumentoActa;

    @Column(length = 100)
    private String DocumentoCedula;

    @ManyToOne(optional = false)
    Aspirante aspirante;

    @ManyToOne(optional = false)
    Administrador administrador;

    public Documentacion() {
    }

    public Documentacion(String tipo_Documento, String estado_Documento,
                         String documentoActa, String documentoCedula) {
        Tipo_Documento = tipo_Documento;
        Estado_Documento = estado_Documento;
        DocumentoActa = documentoActa;
        DocumentoCedula = documentoCedula;
    }

    public String getTipo_Documento() {
        return Tipo_Documento;
    }

    public void setTipo_Documento(String tipo_Documento) {
        Tipo_Documento = tipo_Documento;
    }

    public String getEstado_Documento() {
        return Estado_Documento;
    }

    public void setEstado_Documento(String estado_Documento) {
        Estado_Documento = estado_Documento;
    }

    public String getDocumentoActa() {
        return DocumentoActa;
    }

    public void setDocumentoActa(String documentoActa) {
        DocumentoActa = documentoActa;
    }

    public String getDocumentoCedula() {
        return DocumentoCedula;
    }

    public void setDocumentoCedula(String documentoCedula) {
        DocumentoCedula = documentoCedula;
    }
}
