package clinica.medica.regrasNegocio;

import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.repository.ConsultaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarConsultaPaciente implements ValidadorLista {

    @Autowired
    private ConsultaRepository consultas;

    public void validar(DTOConsulta dados){
        var horario1 = dados.data().withHour(7);
        var horario2 = dados.data().withHour(18);
        var pacienteConsulta = consultas.existsByPacienteIdAndDataBetween(dados.idPaciente(), horario1, horario2);
        if (pacienteConsulta){
                throw new ValidationException("O paciente já possui consulta agendada para esse horário!");
            }


    }
}
