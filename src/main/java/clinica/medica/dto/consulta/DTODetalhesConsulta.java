package clinica.medica.dto.consulta;

import clinica.medica.domain.consulta.Consulta;
import org.springframework.data.domain.Pageable;

import java.nio.channels.FileChannel;
import java.time.LocalDateTime;

public record DTODetalhesConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

    public DTODetalhesConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}