package clinica.medica.dto.paciente;

import clinica.medica.domain.endereco.Endereco;
import clinica.medica.domain.paciente.Paciente;

public record DTOConsultaPaciente(Long id, String nome, String email, String telefone, String cpf , Endereco endereco) {

    public DTOConsultaPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
            }
}
