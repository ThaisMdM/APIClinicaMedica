package clinica.medica.regrasNegocio;

import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.repository.MedicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoAtivo implements ValidadorLista{

    @Autowired
    private MedicoRepository medico;


    public void validar(DTOConsulta dados) {
        var medicoAtivo = medico.findAtivoById(dados.idMedico());
        if (!medicoAtivo) {
            throw new ValidationException("O medico informado não está ativo!");
        }
    }
}
