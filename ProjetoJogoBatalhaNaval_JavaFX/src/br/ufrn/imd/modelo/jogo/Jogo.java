package br.ufrn.imd.modelo.jogo;

import br.ufrn.imd.modelo.jogador.Computador;
import br.ufrn.imd.modelo.jogador.Jogador;

/**
 * Classe que representa o jogo em sí.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Jogo {

    /**
     * Primeiro jogador do jogo.
     */
    private Jogador jogador1;

    /**
     * Segundo jogador do jogo.
     */
    private Jogador jogador2;

    /**
     * Objeto que representa o jogador no modo de jogo contra a CPU.
     */
    private Computador computador;

    /**
     * Diz que é a vez do jogador 1.
     */
    private boolean turnoDoJogadorUm;

    /**
     * Diz que o modo de jogo: contra humano, contra computador ou solo. (!) Melhorias em breve nos modos de jogo.
     */
    private MODO_DE_JOGO modoDeJogo;

    /**
     * Define a dificuldade do jogo: Fácil, Médio ou Difícil. (!) Melhorias em breve nos tipoos de dificuldade.
     */
    private DIFICULDADE dificuldade;

    /**
     * Tamanho padrão do tabuleiro (10x10)... por enquanto...
     */
    public static final int TAM = 10;

    /**
     * Enum dos modos de jogo.
     */
    public enum MODO_DE_JOGO {
        VS_HUMANO,
        VS_COMPUTADOR,
        SOLO;
    }

    /**
     * Enum das dificuldades do jogo.
     */
    public enum DIFICULDADE {
        FACIL,
        MEDIO,
        DIFICIL;
    }

    /**
     * Construtor do jogo.
     * @param j1_nome Nome do jogador 1.
     * @param j2_nome Nome do jogador 2.
     * @param modoDeJogo Modo de jogo (VS_HUMANO, VS_COMPUTADOR ou SOLO).
     * @param dificuldade Dificuldade do jogo (FACIL, MEDIO ou DIFICIL).
     */
    public Jogo(String j1_nome, String j2_nome, MODO_DE_JOGO modoDeJogo, DIFICULDADE dificuldade) {
        this.modoDeJogo = modoDeJogo;
        this.dificuldade = dificuldade;

        this.jogador1 = new Jogador(TAM);

        if (j1_nome != null) {
            this.jogador1.setNome(j1_nome);
        } else {
            this.jogador1.setNome("Jogador 1 Default");
        }

        if (this.modoDeJogo == MODO_DE_JOGO.VS_COMPUTADOR) {
            this.jogador2 = new Computador(TAM);
        } else {
            this.jogador2 = new Jogador(TAM);

            if (j2_nome != null) {
                this.jogador2.setNome(j2_nome);
            } else {
                this.jogador2.setNome("Jogador 2 Default");
            }
        }

        jogador1.setTabuleiroDoInimigo(jogador2.getMeuTabuleiro());
        jogador2.setTabuleiroDoInimigo(jogador1.getMeuTabuleiro());

        this.turnoDoJogadorUm = true;
    }

    /**
     * Ver se o jogo chegou ao fim (todos os barcos de um jogador foram afundados).
     * @return true se o jogo chegou ao fim ou false caso não.
     */
    public boolean fimDoJogo() {
        return jogador1.getMeuTabuleiro().allBarcosAfundados() || jogador2.getMeuTabuleiro().allBarcosAfundados();
    }

    /**
     * Retorna o jogador vencedor.
     * @return O jogador vencedor, ou null se o jogo não tiver um acabad ainda.
     */
    public Jogador vencedor() {
        if (jogador1.getMeuTabuleiro().allBarcosAfundados()) {
            return jogador2;
        } else if (jogador2.getMeuTabuleiro().allBarcosAfundados()) {
            return jogador1;
        } else {
            return null;
        }
    }
    
    /**
     * Troca a vez dos jogadores.
     */
    public void trocaTurno() {
        turnoDoJogadorUm = !turnoDoJogadorUm;
    }

    /**
     * @return O jogador que ta na vez.
     */
    public Jogador turnoDoJogadorUm() {
        return turnoDoJogadorUm ? jogador1 : jogador2;
    }

    /**
     * @return O oponente do jogador que ta na sua vez.
     */
    public Jogador turnoDoOponente() {
        return turnoDoJogadorUm ? jogador2 : jogador1;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador j1) {
        this.jogador1 = j1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador j2) {
        this.jogador2 = j2;
    }

    public Computador getIa() {
        return computador;
    }

    public void setIa(Computador computador) {
        this.computador = computador;
    }

    public boolean isTurnoDaJogada() {
        return turnoDoJogadorUm;
    }


    public void setTurnoDaJogada(boolean turnoDaJogada) {
        this.turnoDoJogadorUm = turnoDaJogada;
    }


    public MODO_DE_JOGO getModoDeJogo() {
        return modoDeJogo;
    }

    public void setModoDeJogo(MODO_DE_JOGO modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }


    public DIFICULDADE getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(DIFICULDADE dificuldade) {
        this.dificuldade = dificuldade;
    }
}
