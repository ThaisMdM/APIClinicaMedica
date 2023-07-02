package clinica.medica.exceptions;

public class ValidacaoPaciente extends RuntimeException {
    public ValidacaoPaciente(String mensagem) {
        super(mensagem);
    }
}
