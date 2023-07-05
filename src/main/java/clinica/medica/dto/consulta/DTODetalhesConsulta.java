package clinica.medica.dto.consulta;

import clinica.medica.domain.consulta.Consulta;
import java.time.LocalDateTime;

public record DTODetalhesConsulta(Long id, String Medico, String Paciente, LocalDateTime data) {

    public DTODetalhesConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getNome(), consulta.getPaciente().getNome(), consulta.getData());
    }

}