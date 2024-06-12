package br.imd;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Tela extends Application{
		//components
		private static Stage stage;
		private BorderPane tlPrincipal;
		
		@Override
		public void start(Stage primaryStage) {
			try {
				stage = primaryStage;
				stage.setTitle("Batalha Naval - THE GAME");
				initPrincipal();
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	    // ==> Tela de Login (Principal)			
		private void initPrincipal() throws IOException {
			FXMLLoader loader =  new FXMLLoader();
			loader.setLocation(br.imd.Tela.class.getResource("/br/ufrn/imd/visao/Principal.fxml"));
			tlPrincipal = (BorderPane) loader.load();
			
			Scene cena = new Scene(tlPrincipal);
			stage.setScene(cena);
		}
		
	    // ==> Tela de Entrada de Dados dos Jogadores
	    public static void paneEntradaDeDados() throws IOException{
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(br.imd.Tela.class.getResource("/br/ufrn/imd/visao/entradaDoUsuario.fxml"));
	        Parent root = (Parent) loader.load();

	        Scene cena = new Scene(root);
	        stage.setTitle("Entradas dos Jogadores");
	        stage.setScene(cena);
	    }

		public static void main(String[] args) {
			launch(args);
		}

		public static Stage getStage() {
			return stage;
		}

		public static void setStage(Stage stage) {
			Tela.stage = stage;
		}
}
