package clinica.medica.regrasNegocio;

import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.repository.ConsultaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarConsultaMedico implements ValidadorLista {

    @Autowired
    private ConsultaRepository consultas;

    public void validar(DTOConsulta dados){
        var horarioConsultaMedico = consultas.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (horarioConsultaMedico){
            throw new ValidationException("O médico já possui consulta agendada para esse horário!");
        }
    }



}
