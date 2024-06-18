package br.ufrn.imd.modelo.interfaces;

/**
 * Interface IJogador define as acoes a todos os jogadores no jogo.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public interface IJogador {

    /**
     * Realiza um ataque em uma determinada coordenada do tabuleiro do oponente.
     * @param x A coordenada X do ataque na coluna.
     * @param y A coordenada Y do ataque na linha.
     * @return `true` se o ataque acertou um barco e `false` caso n�o.
     */
    public boolean atacar(int x, int y);

    /**
     * (!) Melhoria a SER implementada.
     * Retorna a pontua��o total do jogador.
     * @return A pontua��o total do jogador.
     */
    public int pontuacao();
}
