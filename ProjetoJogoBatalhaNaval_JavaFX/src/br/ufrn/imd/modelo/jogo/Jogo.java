package br.ufrn.imd.modelo.jogo;

import br.ufrn.imd.modelo.jogador.Computador;
import br.ufrn.imd.modelo.jogador.Jogador;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Computador computador;
    private boolean turnoDoJogadorUm;
    private MODO_DE_JOGO modoDeJogo;
    private DIFICULDADE dificuldade;
    // Tamanho padrão do tabuleiro
    public static final int TAM = 10;

    public enum MODO_DE_JOGO {
        VS_HUMANO,
        VS_COMPUTADOR,
        SOLO;
    }

    public enum DIFICULDADE {
        FACIL,
        MEDIO,
        DIFICIL;
    }

    public Jogo(String j1_nome, String j2_nome, MODO_DE_JOGO modoDeJogo, DIFICULDADE dificuldade) {
        this.modoDeJogo = modoDeJogo;
        this.dificuldade = dificuldade;

        this.jogador1 = new Jogador(j1_nome, TAM);

        if (this.modoDeJogo == MODO_DE_JOGO.VS_COMPUTADOR) {
            this.jogador2 = new Computador("Computador", TAM);
        } else {
            this.jogador2 = new Jogador(j2_nome, TAM);
            this.jogador2.setNome(j2_nome);
        }
        
        // Ajuste na ligação dos tabuleiros
        jogador1.setTabuleiroDoInimigo(jogador2.getMeuTabuleiro());
        jogador2.setTabuleiroDoInimigo(jogador1.getMeuTabuleiro());
        
        this.turnoDoJogadorUm = true;     
    }
    
    public boolean fimDoJogo() {
        return jogador1.getMeuTabuleiro().allBarcosAfundados() || jogador2.getMeuTabuleiro().allBarcosAfundados();
    }
    
    public Jogador vencedor() {
        if(jogador1.getMeuTabuleiro().allBarcosAfundados()) {
            return jogador2;
        } else if(jogador2.getMeuTabuleiro().allBarcosAfundados()) {
            return jogador1;
        } else {
            return null;
        }
    }
    
    public void trocaTurno() {
        turnoDoJogadorUm = !turnoDoJogadorUm;
    }
    
    public Jogador turnoDoJogadorUm() {
        return turnoDoJogadorUm ? jogador1 : jogador2;
    }
    
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
