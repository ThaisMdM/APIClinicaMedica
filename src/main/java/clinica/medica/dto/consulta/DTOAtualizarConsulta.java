package clinica.medica.dto.consulta;

import clinica.medica.domain.consulta.Consulta;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOAtualizarConsulta(
        @NotNull
        Long id,
        LocalDateTime data){
    public DTOAtualizarConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getData());
    }
}
