package Resultados.Resultados.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Cohorte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignacion_De_Cohorte;


    @Column(length = 100)
    private String Cohorte;

    @Column(length = 100)
    private String Fecha_De_Asignacion;

    @OneToMany(mappedBy = "cohorte")
    List<Estudiante> cohorte;

    public Cohorte() {
    }

    public Cohorte(String cohorte, String fecha_De_Asignacion) {
        Cohorte = cohorte;
        Fecha_De_Asignacion = fecha_De_Asignacion;
    }

    public String getCohorte() {
        return Cohorte;
    }

    public void setCohorte(String cohorte) {
        Cohorte = cohorte;
    }

    public String getFecha_De_Asignacion() {
        return Fecha_De_Asignacion;
    }

    public void setFecha_De_Asignacion(String fecha_De_Asignacion) {
        Fecha_De_Asignacion = fecha_De_Asignacion;
    }
}
