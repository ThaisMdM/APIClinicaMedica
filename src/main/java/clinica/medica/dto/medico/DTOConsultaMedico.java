package clinica.medica.dto.medico;

import clinica.medica.domain.endereco.Endereco;
import clinica.medica.domain.medico.Especialidade;
import clinica.medica.domain.medico.Medico;

public record DTOConsultaMedico(Long id, String nome, String email, String crm, String telefgone, Especialidade especialidade, Endereco endereco) {

    public DTOConsultaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }

}
