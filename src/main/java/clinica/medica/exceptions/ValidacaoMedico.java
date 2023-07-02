package clinica.medica.exceptions;

public class ValidacaoMedico extends RuntimeException {
    public ValidacaoMedico(String mensagem) {
        super(mensagem);
    }
}
