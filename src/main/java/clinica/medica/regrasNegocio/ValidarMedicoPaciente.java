package clinica.medica.regrasNegocio;

import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.exceptions.ValidacaoMedico;
import clinica.medica.exceptions.ValidacaoPaciente;
import clinica.medica.repository.MedicoRepository;
import clinica.medica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoPaciente implements ValidadorLista {

    @Autowired
    private MedicoRepository medico;
    @Autowired
    private PacienteRepository paciente;


        public void validar (DTOConsulta dados) {
            if (!paciente.existsById(dados.idPaciente())) {
                throw new ValidacaoPaciente("ID do paciente não encontrado!");
            }
            if (!medico.existsById(dados.idMedico())) {
                throw new ValidacaoMedico("ID do medico não encontrado!");

            }
        }
}
