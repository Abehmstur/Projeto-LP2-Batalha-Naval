package br.imd;

import java.io.IOException;

import br.imd.tratamentodeerros.TelaException;
import br.ufrn.imd.controler.TelasControler;
import br.ufrn.imd.dao.BarcosDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Classe principal da interface gráfica do jogo. 
 * Esta classe estende a classe `Application` do JavaFX e que gerencia as telas do jogo.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Tela extends Application {
	
    /**
     * Stage principal da aplicação.
     */
    private static Stage stage;

    /**
     * tela inicial/menu do jogo.
     */
    private BorderPane tlPrincipal;
	
    /**
     * Main da aplicação que começa o JavaFX e exibe a tela inicial.
     * @param primaryStage Stage principal da aplicação.
     * @throws IOException Exceção lançada se tiver algum erro no carregamento do arquivo FXML das telas.
     */
	@Override
    public void start(Stage primaryStage) throws IOException {
        try {
        	Image logo = new Image(getClass().getResourceAsStream("/br/ufrn/imd/visao/img/navioExemplo.png"));
        	stage = primaryStage;
        	stage.setTitle("Batalha Naval - THE GAME");
        	stage.getIcons().add(logo);
        	initPrincipal();
	        stage.show();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
    
    /**
     * Inicializa a tela principal do jogo. Carrega o arquivo FXML da tela feita no scene buider.
     * @throws IOException Exceção lançada caso haja algum erro ao carregar o arquivo FXML da tela.
     * @throws TelaException Exceção customizada lançada caso haja algum erro na inicialização da tela.
     */		
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
    
    /**
     * Método que inicia os tabuleiros de cada jogador a partir do controler, cria dois tabuleiros, instancia os barcos, cria um novo grid
     * e adiciona os tabuleiros ao grid por fim define a nova cena.
     * @throws TelaException exceções relacionados ao carregamento de tela.
     */
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
		    BorderPane tituloPane = new BorderPane();

		    
		    Label titulo = new Label("Jogo: Batalha Naval");
		    tituloPane.setTop(titulo);
		    tituloPane.setStyle("-fx-font-family: sans-serif;  -fx-font-size: 30px;");
		    
		    Label jogador1 = new Label("Tabuleiro do Jogador: " + telaController.getJogo().getJogador1().getNome());
		    Label jogador2 = new Label("Tabuleiro do Jogador: " + telaController.getJogo().getJogador2().getNome());
		    gridPane.add(jogador1, 0, 1);
		    gridPane.add(jogador2, 2, 1);
		    gridPane.add(tabuleiro_jogador_1, 0, 0);
		    gridPane.add(tabuleiro_jogador_2, 2, 0);
		    gridPane.setStyle("-fx-font-size: 14px;");
		    gridPane.setHgap(50);
		
		    tituloPane.setCenter(gridPane);
		    StackPane.setMargin(tituloPane, new Insets(50));
		    root.setStyle("-fx-background-color: lightBlue;");
		    
		    root.getChildren().add(tituloPane);
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
