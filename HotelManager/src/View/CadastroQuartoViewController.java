package View;

import Model.QuartoModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import Control.QuartoController;

public class CadastroQuartoViewController {
	QuartoController quartoController = new QuartoController();
	//Declaracao de recursos (elementos) disponiveis para a tela de Cadastro de Quartos
	@FXML
	private Pane mainCadastroDeQuartos;
	
	@FXML
	private Label titleCadastrodeQuartos;
	
	@FXML
	private Label lblDadosQuarto;
	
	@FXML
	private Label lblCamaSolterio;
	
	@FXML
	private Label lblCamaCasal;
	
	@FXML
	private ImageView imgIconCadastroQuartos;
	
	@FXML
	private ImageView imgCancelBtn;
	
	@FXML
	private ImageView imgFinalBtn;
	
	@FXML
	private Separator sepBotton;
	
	@FXML
	private CheckBox checkBoxSuiteEspecial;
	
	@FXML
	private TextField txtBoxNumero;
	
	@FXML
	private TextField txtBoxAndar;
	
	@FXML
	private TextField txtBoxDiaria;
	
	@FXML
	private TextField txtBoxQtdSolteiro;
	
	@FXML
	private TextField txtBoxQtdCasal;
	
	@FXML
	private TextField txtBoxArea;
	
	@FXML
	private Button btnCancelCadQuarto;
	
	@FXML
	private Button btnFinalCadQuarto;
	
	//Declaracao de metodos
	@FXML
	public void cancelarCadastro(){
		mainCadastroDeQuartos.getChildren().clear();
	}
	
	@FXML
	public void finalizarCadastro(){
		if(!txtBoxNumero.getText().isEmpty() && !txtBoxAndar.getText().isEmpty() &&
				!txtBoxDiaria.getText().isEmpty() && !txtBoxQtdSolteiro.getText().isEmpty() &&
				!txtBoxQtdCasal.getText().isEmpty() && !txtBoxArea.getText().isEmpty())
		{
			QuartoModel quarto = new QuartoModel();
			quarto.setNumero(Integer.parseInt(txtBoxNumero.getText()));
			quarto.setAndar(Integer.parseInt(txtBoxAndar.getText()));
			quarto.setValorDiaria(Float.parseFloat(txtBoxDiaria.getText()));
			quarto.setQtdCamasSolteiro(Integer.parseInt(txtBoxQtdSolteiro.getText()));
			quarto.setQtdCamasCasal(Integer.parseInt(txtBoxQtdCasal.getText()));
			quarto.setAreaM2(Float.parseFloat(txtBoxArea.getText()));
			if(checkBoxSuiteEspecial.isSelected())
				quarto.setSuiteEspecial("Sim");
			else
				quarto.setSuiteEspecial("Não");
			quartoController.create(quarto);
			mainCadastroDeQuartos.getChildren().clear();
		}else{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Digite todos os campos");
			alert.showAndWait();
		}
	}
	
}
