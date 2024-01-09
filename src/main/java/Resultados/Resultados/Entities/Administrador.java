package Resultados.Resultados.Entities;

import jakarta.persistence.*;
import org.hibernate.Length;

import java.util.List;

@Entity
@Table
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdministrador;

    @Column(length=100,nullable = false)
    private String UsuarioAdministrador;

    @Column(length=100,nullable = false)
    private String Contrasena;

    @OneToMany(mappedBy = "administrador")
    List<Documentacion> documentacion;

    public Administrador() {
    }

    public Administrador(String usuarioAdministrador, String contrasena) {
        UsuarioAdministrador = usuarioAdministrador;
        Contrasena = contrasena;
    }

    public String getUsuarioAdministrador() {
        return UsuarioAdministrador;
    }

    public void setUsuarioAdministrador(String usuarioAdministrador) {
        UsuarioAdministrador = usuarioAdministrador;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
}
