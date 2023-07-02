package clinica.medica.regrasNegocio;


import clinica.medica.dto.consulta.DTOConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioComercial implements ValidadorLista {

    public void validar(DTOConsulta dados) {
        var dataConsulta = dados.data();
        var sabado = dataConsulta.getDayOfWeek().equals(DayOfWeek.SATURDAY);
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horario1 = dataConsulta.getHour() < 7;
        var horario2 = dataConsulta.getHour() > 18;

        if (sabado || domingo || horario1 || horario2) {
            throw new ValidationException("Consulta fora do horário do comercial");
        }
    }











}