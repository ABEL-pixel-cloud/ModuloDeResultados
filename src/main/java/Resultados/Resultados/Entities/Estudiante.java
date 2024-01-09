package Resultados.Resultados.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredencialEstudiante;


    @ManyToOne(optional = false)
    Cohorte cohorte;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "idAspirante")
    Aspirante aspirante;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "idUsuario")
    Usuario usuario;




    public Estudiante() {
    }

}
