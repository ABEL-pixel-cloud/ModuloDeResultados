package Resultados.Resultados.Dtos;



import Resultados.Resultados.Entity.Estudiante;

import java.util.List;

public class ReciveCohortes {
    private List<Estudiante> idEstudiante;

    private String cohorte;

    public List<Estudiante> getIdEstudiante() {
        return idEstudiante;
    }

    public String getCohorte() {
        return cohorte;
    }
}
