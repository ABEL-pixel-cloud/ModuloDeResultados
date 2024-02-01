package Resultados.Resultados.Dtos;



import Resultados.Resultados.Entity.Aspirante;

import java.util.List;

public class ReciveDocumentosDto {
    private List<Aspirante> idAspirante;

    private Boolean estado;

    public List<Aspirante> getIdAspirante() {
        return idAspirante;
    }

    public Boolean getEstado() {
        return estado;
    }
}
