package clinica.medica.dto.medico;

import clinica.medica.domain.medico.Especialidade;
import clinica.medica.dto.endereco.DTOEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOMedico(

        @NotBlank
        String nome,

        @NotBlank (message = "O campo e-mail é obrigatório")
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DTOEndereco endereco) {

}
