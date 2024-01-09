package Resultados.Resultados.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredencialEstudiante;

    @Column(length = 100)
    private String usuario;

    @Column(length = 100)
    private String contrasena;


    @ManyToOne(optional = false)
    Cohorte cohorte;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "idAspirante")
    Aspirante aspirante;


    public Estudiante() {
    }

    public Estudiante(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
