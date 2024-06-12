package br.ufrn.imd.controler;

import java.io.IOException;

import br.imd.Tela;
import br.ufrn.imd.modelo.jogo.Jogo;
import br.ufrn.imd.modelo.jogo.Jogo.DIFICULDADE;
import br.ufrn.imd.modelo.jogo.Jogo.MODO_DE_JOGO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import br.imd.Tela;

public class TelasControler {
    @FXML
    private TextField nomeJogadorUm;
    @FXML
    private TextField nomeJogadorDois;

    // jogador da esquerda
    private GridPane tabuleiroJogadorUm;
    // jogador da direita
    private GridPane tabuleiroOponente;

    private Jogo jogo;

    public void iniciar(ActionEvent e) throws IOException {
        String nome1 = nomeJogadorUm.getText();
        String nome2 = nomeJogadorDois.getText();
        
        if(nome1.equals("")) {
        	nome1 = null;
        }
        
        if(nome2.equals("")) {
        	nome2 = null;
        }
        
        jogo = new Jogo(nome1, nome2, MODO_DE_JOGO.VS_HUMANO, DIFICULDADE.FACIL);
        Tela.initJogo();
        System.out.println(jogo.getJogador1().getNome());
        System.out.println(jogo.getJogador2().getNome());
    }
    
    public void mostrarRegras(ActionEvent e) {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Regras");
        alert.setHeaderText("Regras do Jogo");
        alert.setContentText("Batalha naval é um jogo de tabuleiro de dois jogadores, no qual os jogadores têm de adivinhar"
        		+ "em quais quadrados estão os navios do oponente. Porém, várias versões foram propostas no"
        		+ "decorrer dos anos. A parte gráfica do jogo evoluiu consideravelmente, pois o jogo foi"
        		+ "originalmente jogado com lápis e papel. Seu objetivo é derrubar os barcos do oponente"
        		+ "adversário, e ganha quem derrubar todos os navios adversários primeiro.");
        alert.showAndWait();
    }

}
