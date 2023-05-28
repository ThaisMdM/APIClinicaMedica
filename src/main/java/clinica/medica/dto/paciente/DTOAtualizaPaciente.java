package clinica.medica.dto.paciente;

import clinica.medica.dto.endereco.DTOEndereco;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizaPaciente(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DTOEndereco endereco) {
}
