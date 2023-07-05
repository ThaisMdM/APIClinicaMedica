package clinica.medica.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public record DTOConsulta(
        @NotNull
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data) {


}
