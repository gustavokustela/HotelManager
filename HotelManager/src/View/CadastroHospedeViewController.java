package View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CadastroHospedeViewController {
	
	//Declara��o de recursos (elementos) dispon�veis para a tela de Cadastro de Hospede	
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
	
	
	//Declara��o de metodos
	@FXML
	public void cancelarCadastro(){
		
	}
	
	@FXML
	public void finalizarCadastro(){
		
	}
}
