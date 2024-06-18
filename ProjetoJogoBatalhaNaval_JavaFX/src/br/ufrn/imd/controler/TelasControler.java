package br.ufrn.imd.controler;

import br.imd.Tela;
import br.imd.tratamentodeerros.TelaException;
import br.ufrn.imd.modelo.jogador.Jogador;
import br.ufrn.imd.modelo.jogo.Jogo;
import br.ufrn.imd.modelo.jogo.Tabuleiro;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class TelasControler extends GridPane {
    @FXML private TextField nomeJogadorUm;
    @FXML private TextField nomeJogadorDois;
    
    private Jogo jogo;
    private Jogador jogador;
    private GridPane jogadorGrid;
    private GridPane oponenteGrid;
    private static HBox mensagemBox = null;
    
    public TelasControler() {     
    	this.jogo = new Jogo("ELON", "MARK", Jogo.MODO_DE_JOGO.VS_HUMANO, Jogo.DIFICULDADE.FACIL);
        this.jogador = jogo.getJogador1();
    }
    
    /**
     * Método que adiciona uma imagem de fundo de um backgroudImage.
     * @param imagem Imagem a ser utilizada como fundo.
     * @return Objeto BackgroundImage contendo a imagem.
     */
    private BackgroundImage addImgBackgroud(Image i) {
    	return new BackgroundImage(i, null, null, null, null);
    }
    
    /**
     * Método que cria o grid do tabuleiro do jogo.
     * @param tabuleiro Tabuleiro do jogo.
     * @param jogadorHumano Indica se o tabuleiro é do jogador humano. (!) Melhorias: trazer as acoes do jogador computador.
     * @param jogo em andamento.
     * @return GridPane GridPane contendo o tabuleiro do jogo.
     */
	public GridPane criarTabuleiro(Tabuleiro tabuleiro, boolean jogadorHumano, Jogo jogo) {
        
    	GridPane gridTabuleiro = new GridPane();
        gridTabuleiro.setAlignment(Pos.CENTER);
        gridTabuleiro.setHgap(1);
        gridTabuleiro.setVgap(1);
                     
        int tamanho = Jogo.TAM;
        
        Image imagemMar = new Image(getClass().getResourceAsStream("/br/ufrn/imd/visao/img/mar.png"));
        Image explosao = new Image(getClass().getResourceAsStream("/br/ufrn/imd/visao/img/explosao/expl_04_0020-2.png"));
                       
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                Button celula = new Button("~");
                celula.setBackground(new Background(addImgBackgroud(imagemMar)));
                
                celula.setMinWidth(40);
                celula.setMinHeight(40);
                
                if (jogadorHumano) {
                    int x = i;
                    int y = j;
                    
                    celula.setOnMouseClicked(e -> {
                    	
                        boolean ataqueBemSucedido = false;
						
						ataqueBemSucedido = tabuleiro.levarAtaque(x, y);
						
                        if (ataqueBemSucedido) {
                            celula.setDisable(true);
                            celula.setText(tabuleiro.getCelulaDoMar(x, y).toString());
                            celula.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                            if(tabuleiro.getCelulaDoMar(x, y).getBarco().isAfundado()) {
                            	exibirMensagem(gridTabuleiro, "Você afundou um barco: " +  tabuleiro.getCelulaDoMar(x, y).getBarco().getNome());
                            }
                            exibirMensagem(gridTabuleiro, "Ataque do jogador: " + jogo.turnoDoJogadorUm().getNome() + " acertou o alvo!");
                        } else {
                            celula.setDisable(true);
                            celula.setOpacity(0.8);
                            celula.setText("");
                            celula.setBackground(new Background(addImgBackgroud(explosao)));
                            exibirMensagem(gridTabuleiro, "Ataque do jogador: " + jogo.turnoDoJogadorUm().getNome() + " errou!");
                        }
                        
                        if (jogo.fimDoJogo()) {
                            Jogador vencedor = jogo.vencedor();
                            if (vencedor != null) {
                                MensagemFimDoJogo(vencedor);
                                gridTabuleiro.setDisable(true);
                            } else {
                                System.out.println("O jogo terminou em empate!");
                            }
                        }
                        jogo.trocaTurno();
                    });
                }
                gridTabuleiro.add(celula, j, i);
            }
        }

        return gridTabuleiro;
    }
    
	/**
	 * Método que exibe uma mensagem temporária no grid do tabuleiro.
	 * @param gridTabuleiro GridPane do tabuleiro onde a mensagem será exibida.
	 * @param mensagem Texto da mensagem a ser exibida.
	 */
    public static void exibirMensagem(GridPane gridTabuleiro, String mensagem) {       
        if (mensagemBox != null) {
            gridTabuleiro.getChildren().remove(mensagemBox);
        }
       
        Label label = new Label(mensagem);
        mensagemBox = new HBox(label);
        mensagemBox.setAlignment(Pos.CENTER);
        gridTabuleiro.add(mensagemBox, 0, Jogo.TAM + 2, Jogo.TAM * 2 + 1, 1);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> gridTabuleiro.getChildren().remove(mensagemBox));
        pause.play();
    }

    /**
     * Método que exibe uma janela de mensagem informando o vencedor do jogo.
     * @param jogador Jogador vencedor da partida.
     */
    public static void MensagemFimDoJogo(Jogador jogador) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("FIM!!!");
        alert.setContentText("Jogo Finalizado, o jogador: " + jogador.getNome() + " é o vencedor!!!");
        alert.showAndWait();
    }
    
    /**
     * Método acionado pelo evento do botão "Regras" na tela principal.
     * @param e Evento do botão.
     */
    public void mostrarRegras(ActionEvent e) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Regras");
        alert.setHeaderText("Regras do Jogo");
        alert.setContentText("Batalha naval é um jogo de tabuleiro de dois jogadores, no qual os jogadores têm de adivinhar"
            + " em quais quadrados estão os navios do oponente. Porém, várias versões foram propostas no"
            + " decorrer dos anos. A parte gráfica do jogo evoluiu consideravelmente, pois o jogo foi"
            + " originalmente jogado com lápis e papel. Seu objetivo é derrubar os barcos do oponente"
            + " adversário, e ganha quem derrubar todos os navios adversários primeiro.");
        alert.showAndWait();
    }
    
    /**
     * Método acionado pelo evento do botão "Iniciar" e começa o jogo.
     * @param e Evento do botão.
     * @throws TelaException Exceção lançada caso ocorra algum erro.
     */
    public void iniciar(ActionEvent e) throws TelaException {
        
//    	(!) pendente pegar os nomes da FXML do front e atualizar no jogo.
        String nome1 = nomeJogadorUm.getText();
        String nome2 = nomeJogadorDois.getText();
        
        if(nome1.equals("")) {
            nome1 = null;
        }
        
        if(nome2.equals("")) {
            nome2 = null;
        }
        
        Tela.initTabuleiro();
    }
    
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public GridPane getJogadorGrid() {
        return jogadorGrid;
    }

    public void setJogadorGrid(GridPane jogadorGrid) {
        this.jogadorGrid = jogadorGrid;
    }

    public GridPane getOponenteGrid() {
        return oponenteGrid;
    }

    public void setOponenteGrid(GridPane oponenteGrid) {
        this.oponenteGrid = oponenteGrid;
    }
}
