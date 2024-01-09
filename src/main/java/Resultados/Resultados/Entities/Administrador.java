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

    @OneToMany(mappedBy = "administrador")
    List<Documentacion> documentacion;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "idUsuario")
    Usuario usuario;

    public Administrador() {
    }

}
