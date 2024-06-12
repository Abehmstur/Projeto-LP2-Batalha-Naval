module ProjetoJogoBatalhaNaval_JavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens br.imd to javafx.graphics, javafx.fxml;
	opens br.ufrn.imd.controler to javafx.graphics, javafx.fxml;
	exports br.ufrn.imd.controler;
}
