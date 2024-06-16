package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Random;

import br.ufrn.imd.modelo.barco.Barco;
import br.ufrn.imd.modelo.barco.Corverta;
import br.ufrn.imd.modelo.barco.Destroyer;
import br.ufrn.imd.modelo.barco.Fragata;
import br.ufrn.imd.modelo.barco.Pesqueiro;
import br.ufrn.imd.modelo.barco.Submarino;
import br.ufrn.imd.modelo.jogador.Jogador;

public class BarcosDAO {
    private static BarcosDAO bDao;

    private BarcosDAO() {}

    public static BarcosDAO getInstance() {
        if (bDao == null) {
            bDao = new BarcosDAO();
        }
        return bDao;
    }

    public void inicializarBarcos(Jogador jogador) {
        Random random = new Random();
        ArrayList<Barco> barcosAdicionadosNoTabuleiro;
        barcosAdicionadosNoTabuleiro = new ArrayList<>();
        Barco[] barcos = new Barco[] {
            new Destroyer(),
            new Submarino(),
            new Fragata(),
            new Corverta(),
//            new Pesqueiro() //"melhoria trazer efeito de dano..."
        };

        for (Barco barco : barcos) {
            for (int i = 0; i < barco.getQuantidadeMaximaDeBarcos(); i++) {
                boolean colocado = false;

                while (!colocado) {
                    int x = random.nextInt(jogador.getMeuTabuleiro().getTamanho());
                    int y = random.nextInt(jogador.getMeuTabuleiro().getTamanho());
                    boolean vertical = random.nextBoolean();

                    colocado = jogador.getMeuTabuleiro().colocarBarco(barco, x, y, vertical, barcosAdicionadosNoTabuleiro);
                }
            }
        }
    }
}
