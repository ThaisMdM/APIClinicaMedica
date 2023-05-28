package clinica.medica.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOEndereco(

        @NotBlank
        String logradouro,

        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")

        @NotBlank
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf) {
}
