package br.ufrn.imd.modelo.jogador;

import br.ufrn.imd.modelo.interfaces.IJogador;
import br.ufrn.imd.modelo.jogo.Tabuleiro;

public class Jogador implements IJogador {
    protected String nome = "Jogador Default";
    protected Tabuleiro meuTabuleiro;
    protected Tabuleiro tabuleiroDoInimigo;

    public Jogador(int tamanhoTabuleiro) {
        this.meuTabuleiro = new Tabuleiro(tamanhoTabuleiro);
    }

    @Override
    public boolean atacar(int x, int y) {
        return tabuleiroDoInimigo.levarAtaque(x, y);
    }

    @Override
    public int pontuacao() {
        // Determinar pontua��o futuramente
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
