package br.imd;

import java.io.IOException;

import br.imd.tratamentodeerros.TelaException;
import br.ufrn.imd.controler.TelasControler;
import br.ufrn.imd.dao.BarcosDAO;
import br.ufrn.imd.modelo.jogo.Jogo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tela extends Application {
	
	private static Stage stage;
	private BorderPane tlPrincipal;
	private Jogo jogo;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
        	stage = primaryStage;
        	stage.setTitle("Batalha Naval - THE GAME");
	        
        	initPrincipal();
	        stage.show();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
    
    // ==> Tela Inicial (Principal)			
    private void initPrincipal() throws IOException, TelaException {
		try {
	    	FXMLLoader loader =  new FXMLLoader();
			loader.setLocation(br.imd.Tela.class.getResource("/br/ufrn/imd/visao/Principal.fxml"));
			tlPrincipal = (BorderPane) loader.load();
			
			Scene cena = new Scene(tlPrincipal);
			stage.setScene(cena);
		} catch (IOException e) {
			throw new TelaException("Erro ao inicializar a tela principal." + "Exception:" + e.getMessage() + " " + e.getCause());			
		}
	}
    
    // ==> Tabuleiros
public static void initTabuleiro() throws TelaException {
	try {
		StackPane root = new StackPane();
	    root.setAlignment(Pos.CENTER);
	    
	    TelasControler telaController = new TelasControler();
	
	    GridPane tabuleiro_jogador_1 = telaController.criarTabuleiro(telaController.getJogo().getJogador1().getMeuTabuleiro(), true, telaController.getJogo());
	    GridPane tabuleiro_jogador_2 = telaController.criarTabuleiro(telaController.getJogo().getJogador2().getMeuTabuleiro(), true, telaController.getJogo());
	    
        BarcosDAO.getInstance().inicializarBarcos(telaController.getJogo().getJogador1());
        BarcosDAO.getInstance().inicializarBarcos(telaController.getJogo().getJogador2());
	
	    GridPane gridPane = new GridPane();
	    
	    Label jogador1 = new Label("Tabuleiro do Jogador: " + telaController.getJogo().getJogador1().getNome());
	    Label jogador2 = new Label("Tabuleiro do Jogador: " + telaController.getJogo().getJogador2().getNome());
	    gridPane.add(jogador1, 0, 1);
	    gridPane.add(jogador2, 2, 1);
	    gridPane.add(tabuleiro_jogador_1, 0, 0);
	    gridPane.add(tabuleiro_jogador_2, 2, 0);
	
	    gridPane.setHgap(50);
	
	    StackPane.setMargin(gridPane, new Insets(50));
	
	    root.getChildren().add(gridPane);
	    Scene scene = new Scene(root, 1000, 600);
	    stage.setScene(scene);
	} catch (Exception e) {
		throw new TelaException("Erro ao cria os tabuleiros.");
	}
    
}
    public static void main(String[] args) {
        launch(args);
    }
}
