package clinica.medica.regrasNegocio;

import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.repository.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteAtivo implements ValidadorLista{

    @Autowired
    private PacienteRepository paciente;

    public void validar(DTOConsulta dados) {
        var pacienteAtivo = paciente.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo) {
            throw new ValidationException("O paciente informado não está ativo!");
        }

    }
}
