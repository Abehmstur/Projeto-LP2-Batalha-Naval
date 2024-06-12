package br.ufrn.imd.visao;

import java.util.Scanner;

import br.ufrn.imd.dao.BarcosDAO;
import br.ufrn.imd.modelo.jogador.Jogador;
import br.ufrn.imd.modelo.jogo.Jogo;
import br.ufrn.imd.modelo.jogo.Tabuleiro;

public class JogoView {

	public static void main(String[] args) {
        Jogo jogo = new Jogo("Jogador 1", "Jogador 2", Jogo.MODO_DE_JOGO.VS_HUMANO, Jogo.DIFICULDADE.FACIL);
        BarcosDAO.getInstance().inicializarNavios(jogo.getJogador1());
        BarcosDAO.getInstance().inicializarNavios(jogo.getJogador2());

        Scanner scanner = new Scanner(System.in);

        while (!jogo.fimDoJogo()) {
            System.out.println("Tabuleiro do " + jogo.turnoDoJogadorUm().getNome() + ":");
            imprimirTabuleiro(jogo.turnoDoJogadorUm().getMeuTabuleiro());
            System.out.println();

            System.out.println("Tabuleiro do " + jogo.turnoDoOponente().getNome() + ":");
            imprimirTabuleiro(jogo.turnoDoOponente().getMeuTabuleiro());
            System.out.println();

            System.out.print("Informe a linha (0-9): ");
            int x = scanner.nextInt();
            System.out.print("Informe a coluna (0-9): ");
            int y = scanner.nextInt();

            boolean ataqueBemSucedido = jogo.turnoDoJogadorUm().atacar(x, y);

            if (ataqueBemSucedido) {
                System.out.println("Ataque do " + jogo.turnoDoJogadorUm().getNome() + " em (" + x + ", " + y + ") acertou!!!!");
            } else {
                System.out.println("Ataque do " + jogo.turnoDoJogadorUm().getNome() + " em (" + x + ", " + y + ") nao acertou!!!!");
            }

            jogo.trocaTurno();
            System.out.println("=== Próximo turno ===\n");
        }

        Jogador vencedor = jogo.vencedor();
        if (vencedor != null) {
        	scanner.close();
            System.out.println("Parabens " + vencedor.getNome() + "!! por vencer o jogo!!!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }
    }

    public static void imprimirTabuleiro(Tabuleiro tabuleiro) {
        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                System.out.print(tabuleiro.getCelulaDoMar(i, j) + " ");
            }
            System.out.println();
        }
    }
}
