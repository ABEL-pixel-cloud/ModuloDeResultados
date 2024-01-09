package Resultados.Resultados.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAspirante;

    @Column(length = 100)
    private String Tipo_De_Documento;

    @Column
    private Long Documento;

    @Column(length = 100)
    private String Nombres_Completos;

    @Column
    private Long Telefono;

    @Column(length = 100)
    private String Correo;

    @Column(length = 100)
    private String Tipo_De_Perfil;

    @Column(length = 100)
    private String Estado_De_Proceso;

    @Column
    private Double Resultado_Prueba_Gorilla;

    @Column(length = 100)
    private String Link_De_Prueba;

    @Column(length = 100)
    private Boolean Admitido;

    @Column(length = 100)
    private String Financiador;

    @Column(length = 100)
    private String Programa;

    @Column(length = 100)
    private String Observacion;

    @OneToMany(mappedBy = "aspirante")
    List<Documentacion> documentacion;

    @OneToOne(mappedBy = "aspirante",cascade = CascadeType.ALL,optional= false)
    @PrimaryKeyJoinColumn
    private Estudiante estudiante;


    public Aspirante() {
    }

    public Aspirante(String tipo_De_Documento, Long documento, String nombres_Completos,
                     Long telefono, String correo, String tipo_De_Perfil, String estado_De_Proceso,
                     Double resultado_Prueba_Gorilla, String link_De_Prueba, Boolean admitido,
                     String financiador, String programa, String observacion) {
        Tipo_De_Documento = tipo_De_Documento;
        Documento = documento;
        Nombres_Completos = nombres_Completos;
        Telefono = telefono;
        Correo = correo;
        Tipo_De_Perfil = tipo_De_Perfil;
        Estado_De_Proceso = estado_De_Proceso;
        Resultado_Prueba_Gorilla = resultado_Prueba_Gorilla;
        Link_De_Prueba = link_De_Prueba;
        Admitido = admitido;
        Financiador = financiador;
        Programa = programa;
        Observacion = observacion;
    }

    public String getTipo_De_Documento() {
        return Tipo_De_Documento;
    }

    public void setTipo_De_Documento(String tipo_De_Documento) {
        Tipo_De_Documento = tipo_De_Documento;
    }

    public Long getDocumento() {
        return Documento;
    }

    public void setDocumento(Long documento) {
        Documento = documento;
    }

    public String getNombres_Completos() {
        return Nombres_Completos;
    }

    public void setNombres_Completos(String nombres_Completos) {
        Nombres_Completos = nombres_Completos;
    }

    public Long getTelefono() {
        return Telefono;
    }

    public void setTelefono(Long telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTipo_De_Perfil() {
        return Tipo_De_Perfil;
    }

    public void setTipo_De_Perfil(String tipo_De_Perfil) {
        Tipo_De_Perfil = tipo_De_Perfil;
    }

    public String getEstado_De_Proceso() {
        return Estado_De_Proceso;
    }

    public void setEstado_De_Proceso(String estado_De_Proceso) {
        Estado_De_Proceso = estado_De_Proceso;
    }

    public Double getResultado_Prueba_Gorilla() {
        return Resultado_Prueba_Gorilla;
    }

    public void setResultado_Prueba_Gorilla(Double resultado_Prueba_Gorilla) {
        Resultado_Prueba_Gorilla = resultado_Prueba_Gorilla;
    }

    public String getLink_De_Prueba() {
        return Link_De_Prueba;
    }

    public void setLink_De_Prueba(String link_De_Prueba) {
        Link_De_Prueba = link_De_Prueba;
    }

    public Boolean getAdmitido() {
        return Admitido;
    }

    public void setAdmitido(Boolean admitido) {
        Admitido = admitido;
    }

    public String getFinanciador() {
        return Financiador;
    }

    public void setFinanciador(String financiador) {
        Financiador = financiador;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setPrograma(String programa) {
        Programa = programa;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }


}
