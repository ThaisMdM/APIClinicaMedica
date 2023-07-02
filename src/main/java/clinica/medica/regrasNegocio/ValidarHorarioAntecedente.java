package clinica.medica.regrasNegocio;

import clinica.medica.dto.consulta.DTOConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarHorarioAntecedente implements ValidadorLista {

    public void validar(DTOConsulta dados) {
        var dataConsulta = dados.data();
        var horarioAtual = LocalDateTime.now();
        var diferencaHoras = Duration.between(horarioAtual, dataConsulta).toHours();
        if (diferencaHoras < 1) {
            throw new ValidationException("Consultas devem ser agendadas com antecedencia minima de 1 hora");
        }
    }
}
