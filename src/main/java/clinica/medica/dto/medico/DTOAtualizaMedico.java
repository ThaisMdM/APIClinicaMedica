package clinica.medica.dto.medico;


import clinica.medica.domain.endereco.Endereco;
import clinica.medica.domain.medico.Medico;
import clinica.medica.dto.endereco.DTOEndereco;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizaMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DTOEndereco endereco) {


}

