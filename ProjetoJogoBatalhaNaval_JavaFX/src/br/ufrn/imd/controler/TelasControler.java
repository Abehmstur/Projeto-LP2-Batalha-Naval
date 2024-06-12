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
	private JogoControler jogoControler;
	private Jogo jogo;
	
    @FXML
    private BorderPane painelPrincipal;

    @FXML
    private MenuItem playMenuItem;

    @FXML
    private MenuItem regrasMenuItem;
    
    //inputs
    @FXML private TextField nomeJogadorUm;
    @FXML private TextField nomeJogadorDois;
    

  //jogador da esquerda
    private GridPane tabuleiroJogadorUm;
    //jogador da direito
    private GridPane tabuleiroOponente;
    
    public void iniciar(ActionEvent e) throws IOException {
    	jogo = new Jogo("Jogador_1", "Jogador_2", MODO_DE_JOGO.VS_HUMANO, DIFICULDADE.FACIL);
    	Tela.paneEntradaDeDados();
    }
    
    public void mostrarRegras(ActionEvent e) {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Regras");
        alert.setHeaderText("Regras do Jogo");
        alert.setContentText("Batalha naval � um jogo de tabuleiro de dois jogadores, no qual os jogadores t�m de adivinhar"
        		+ "em quais quadrados est�o os navios do oponente. Por�m, v�rias vers�es foram propostas no"
        		+ "decorrer dos anos. A parte gr�fica do jogo evoluiu consideravelmente, pois o jogo foi"
        		+ "originalmente jogado com l�pis e papel. Seu objetivo � derrubar os barcos do oponente"
        		+ "advers�rio, e ganha quem derrubar todos os navios advers�rios primeiro.");
        alert.showAndWait();
    }

}
