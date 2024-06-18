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
     * @return `true` se o ataque acertou um barco e `false` caso não.
     */
    public boolean atacar(int x, int y);

    /**
     * (!) Melhoria a SER implementada.
     * Retorna a pontuação total do jogador.
     * @return A pontuação total do jogador.
     */
    public int pontuacao();
}
