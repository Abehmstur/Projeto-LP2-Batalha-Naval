package br.ufrn.imd.modelo.jogador;

import br.ufrn.imd.modelo.interfaces.IJogador;
import br.ufrn.imd.modelo.jogo.Tabuleiro;

/**
 * Classe que representa um jogador no jogo Batalha Naval.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Jogador implements IJogador {

    /**
     * Nome do jogador DEFAULT caso seja null nas entradas.
     */
    protected String nome = "Jogador Default";

    /**
     * Tabuleiro do jogador.
     */
    protected Tabuleiro meuTabuleiro;

    /**
     * Tabuleiro do oponente.
     */
    protected Tabuleiro tabuleiroDoInimigo;

    /**
     * Construtor que inicializa o jogador com um tabuleiro de tamanho especificado.
     * (!) Melhoria: a ideia é pegar como entrada a dificuldade do jogo e mudar o tamanho do tabuleiro.
     * @param tamanhoTabuleiro O tamanho do tabuleiro do jogador.
     */
    public Jogador(int tamanhoTabuleiro) {
        this.meuTabuleiro = new Tabuleiro(tamanhoTabuleiro);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean atacar(int x, int y) {
        return tabuleiroDoInimigo.levarAtaque(x, y);
    }

    /**
     * {@inheritDoc}
     * **Observação:** A implementação da pontuação ainda é uma melhoria pendente.
     */
    @Override
    public int pontuacao() {
        // Determinar pontuação futuramente
        return 0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tabuleiro getMeuTabuleiro() {
        return meuTabuleiro;
    }

    public void setMeuTabuleiro(Tabuleiro meuTabuleiro) {
        this.meuTabuleiro = meuTabuleiro;
    }

    public Tabuleiro getTabuleiroDoInimigo() {
        return tabuleiroDoInimigo;
    }

    public void setTabuleiroDoInimigo(Tabuleiro tabuleiroDoInimigo) {
        this.tabuleiroDoInimigo = tabuleiroDoInimigo;
    }
}
