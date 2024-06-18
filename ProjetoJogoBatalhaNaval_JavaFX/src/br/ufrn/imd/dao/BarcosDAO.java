package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Random;

import br.ufrn.imd.modelo.barco.Barco;
import br.ufrn.imd.modelo.barco.Corverta;
import br.ufrn.imd.modelo.barco.Destroyer;
import br.ufrn.imd.modelo.barco.Fragata;
import br.ufrn.imd.modelo.barco.Submarino;
import br.ufrn.imd.modelo.jogador.Jogador;

/**
 * Classe responsável por inicializar os barcos no jogo.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class BarcosDAO {

    /**
     * Instância da classe seguindo o padrão Singleton.
     */
    private static BarcosDAO bDao;

    /**
     * Construtor privado para evitar a criação deinstâncias.
     */
    private BarcosDAO() {}

    /**
     * Retona a instância da classe BarcosDAO.
     * @return A instância única de BarcosDAO.
     */
    public static BarcosDAO getInstance() {
        if (bDao == null) {
            bDao = new BarcosDAO();
        }
        return bDao;
    }

    /**
     * Inicializa os barcos no tabuleiro do jogador.
     * @param jogador para quem os barcos serão inicializados.
     */
    public void inicializarBarcos(Jogador jogador) {
        Random random = new Random();

//     Cria um array de objetos Barco representando os diferentes tipos de barcos disponíveis.
        Barco[] barcos = new Barco[] {
            new Destroyer(),
            new Submarino(),
            new Fragata(),
            new Corverta(),
//          new Pesqueiro() // "melhoria trazer efeito de dano..."
        };

        for (Barco barco : barcos) {
            for (int i = 0; i < barco.getQuantidadeMaximaDeBarcos(); i++) {
                boolean colocado = false;

                while (!colocado) {
                    int x = random.nextInt(jogador.getMeuTabuleiro().getTamanho());
                    int y = random.nextInt(jogador.getMeuTabuleiro().getTamanho());
                    boolean vertical = random.nextBoolean();

                    colocado = jogador.getMeuTabuleiro().colocarBarco(barco, x, y, vertical);
                }
            }
        }
    }
}