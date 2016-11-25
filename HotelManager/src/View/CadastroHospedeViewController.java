package View;

import Model.HospedeModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import Control.HospedeController;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class CadastroHospedeViewController {
    HospedeController hospedeController = new HospedeController();
	//Declaracao de recursos (elementos) disponiveis para a tela de Cadastro de Hospede

	@FXML
	private Pane mainCadastroDeHospedes;
	
	@FXML
	private Label titleCadastroDeHospedes;
	
	@FXML
	private Label lblDadosPessoais;
	
	@FXML
	private Label lblDadosDeContato;
	
	@FXML
	private Label lblDadosDeEndereco;
	
	@FXML
	private Separator sepBotton;
	
	@FXML
	private Separator sepMid;
	
	@FXML
	private Separator sepTop;
	
	@FXML
	private ImageView imgIconCadastroDeHospedes;
	
	@FXML
	private ImageView imgCancelBtn;

	@FXML
	private ImageView imgFinalBtn;
	
	@FXML
	private TextField txtNomeHosp;
	
	@FXML
	private TextField txtRgHosp;	
	
	@FXML
	private TextField txtCpfHosp;
	
	@FXML
	private TextField txtDtNascHosp;
	
	@FXML
	private TextField txtSexoHosp;
	
	@FXML
	private TextField txtTelHosp;
	
	@FXML
	private TextField txtEmailHosp;	
	
	@FXML
	private TextField txtEndLogradouroHosp;
	
	@FXML
	private TextField txtEndNrHosp;
	
	@FXML
	private TextField txtEndCidadeHosp;
	
	@FXML
	private TextField txtEndBairroHosp;
	
	@FXML
	private TextField txtEndEstadoHosp;
	
	@FXML
	private CheckBox checkBoxIsEstrangeiroHosp;
	
	@FXML
	private Button btnCancelCadHosp;
	
	@FXML
	private Button btnFinalCadHosp;
	
	
	//declaracao de metodos
	@FXML
	public void cancelarCadastro(){
		mainCadastroDeHospedes.getChildren().clear();
	}
	
	@FXML
	public void finalizarCadastro() throws IOException {
		if(!txtNomeHosp.getText().isEmpty() && !txtDtNascHosp.getText().isEmpty() &&
				!txtRgHosp.getText().isEmpty() && !txtCpfHosp.getText().isEmpty() &&
				!txtSexoHosp.getText().isEmpty() && !txtTelHosp.getText().isEmpty() &&
				!txtEmailHosp.getText().isEmpty() && !txtEndLogradouroHosp.getText().isEmpty() &&
				!txtEndNrHosp.getText().isEmpty() && !txtEndBairroHosp.getText().isEmpty() &&
				!txtEndCidadeHosp.getText().isEmpty() && !txtEndEstadoHosp.getText().isEmpty())
		{
            HospedeModel hospede = new HospedeModel();
            hospede.setNome(txtNomeHosp.getText());
            hospede.setDataNasc(txtDtNascHosp.getText());
            hospede.setRG(txtRgHosp.getText());
            hospede.setCpf(txtCpfHosp.getText());
            hospede.setSexo(txtSexoHosp.getText());
            hospede.setTelefone(txtTelHosp.getText());
            hospede.setEmail(txtEmailHosp.getText());
            hospede.setEndereco(txtEndLogradouroHosp.getText() + ", " +
            txtEndNrHosp.getText() + ", " + txtEndBairroHosp.getText() + ", " +
            txtEndCidadeHosp.getText() + ", " + txtEndEstadoHosp.getText());
			if(checkBoxIsEstrangeiroHosp.isSelected())
				hospede.setEstrangeiro(1);
			else
				hospede.setEstrangeiro(0);
            hospedeController.create(hospede);
			mainCadastroDeHospedes.getChildren().clear();
		}else{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Digite todos os campos");
			alert.showAndWait();
		}
	}
}
