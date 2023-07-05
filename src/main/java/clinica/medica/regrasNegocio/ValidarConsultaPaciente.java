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
        var horarioConsultaPaciente = consultas.existsByPacienteIdAndData(dados.idPaciente(), dados.data());
        if (horarioConsultaPaciente){
                throw new ValidationException("O paciente já possui consulta agendada para esse horário!");
            }


    }
}
