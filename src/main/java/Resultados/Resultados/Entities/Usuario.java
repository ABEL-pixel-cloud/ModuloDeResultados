package Resultados.Resultados.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 100)
    private String Usuario;

    @Column(length = 100)
    private String Contrasena;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL,optional= false)
    @PrimaryKeyJoinColumn
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL,optional= false)
    @PrimaryKeyJoinColumn
    private Administrador administrador;



}