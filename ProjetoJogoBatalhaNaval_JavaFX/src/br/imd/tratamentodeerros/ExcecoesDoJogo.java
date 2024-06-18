package br.imd.tratamentodeerros;

/**
 * Classe que representa exceções do jogo.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class ExcecoesDoJogo extends Exception {

    /**
     * Valor da serialVersionUID gerado automaticamente.
     */
    private static final long serialVersionUID = -4038821394529204199L;

    /**
     * Mensagem de erro da exceção.
     */
    private String mensagem;

    /**
     * Construtor da exceção.
     * @param mensagem Mensagem de erro a ser da exceção.
     */
    public ExcecoesDoJogo(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
