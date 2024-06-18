package br.ufrn.imd.modelo.jogador;

import java.util.Random;

/**
 * Classe que representa um jogador cpu no jogo Batalha Naval.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Computador extends Jogador {

    /**
     * Gera n�meros aleat�rios para ataques dependendo do tamanho do tabuleiro do jogador.
     */
    private Random random;

    /**
     * Construtor que inicializa o jogador computador com um nome e tamanho de tabuleiro.
     * @param nome O nome do jogador computador.
     * @param tamanhoTabuleiro O tamanho do tabuleiro do jogador.
     */
    public Computador(int tamanhoTabuleiro) {
        super(tamanhoTabuleiro);
        this.nome = "CPU-Z";
        this.random = new Random();
    }

    /**
     * Realiza um ataque aleat�rio no tabuleiro do inimigo.
     */
    public void atacar() {
        int x, y;
        boolean acertou = false;

        while (!acertou) {
            x = random.nextInt(getTabuleiroDoInimigo().getTamanho());
            y = random.nextInt(getTabuleiroDoInimigo().getTamanho());

            // Verifica se a c�lula do mar ainda n�o foi atacada antes de realizar o ataque.
            if (!getTabuleiroDoInimigo().getCelulaDoMar(x, y).isAtacado()) {
                acertou = getTabuleiroDoInimigo().levarAtaque(x, y);

                /* 
                 * Coment�rio sobre l�gica de ataque sequencial desativado:
                 * 
                 * A implementa��o original permitia que o computador atacasse novamente se acertasse um barco. 
                 * No entanto, essa l�gica precisa ser aprimorada para analisar a �rea ao redor e atacar 
                 * estrategicamente em locais pr�ximos ao barco encontrado. 
                 * 
                 * Por enquanto, cada jogador joga e passa a vez, independentemente de ter acertado ou n�o.
                 */

                // if (acertou) {
                //     atacar();
                // }
            }
        }
    }
}
