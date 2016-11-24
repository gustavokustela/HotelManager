package View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CadastroUsuarioViewController {
	
	//Declaracao de recursos (elementos) disponiveis para Tela de Cadastro de Usuarios
	@FXML
	private Pane mainCadastroDeUsuarios;
	@FXML
	private TextField txtBoxNomeUser;
	
	@FXML
	private TextField txtBoxDtNascUser;

	@FXML
	private TextField txtBoxRgUser;
	
	@FXML
	private TextField txtBoxCpfUser;
	
	@FXML
	private TextField txtBoxSexoUser;
	
	@FXML
	private TextField txtBoxSalarioUser;
	
	@FXML
	private TextField txtBoxTelefoneUser;
	
	@FXML
	private TextField txtBoxUserLogin;

	@FXML
	private TextField txtBoxUserPassword;
	
	@FXML
	private TextField txtBoxEndLougradouro;
	
	@FXML
	private TextField txtBoxEndNumero;
	
	@FXML
	private TextField txtBoxEndBairro;
	
	@FXML
	private TextField txtBoxEndCidade;
	
	@FXML
	private TextField txtBoxEndEstado;
	
	@FXML
	private CheckBox checkBoxIsAdminSistema;
	
	@FXML
	private Button btnCancelCadUser;
	
	@FXML
	private Button btnFinalCadUser;
	
	@FXML
	private ImageView imgCancelCadButton;
	
	@FXML
	private ImageView imgFinalCadButton;
	
	@FXML
	private ImageView imgCadastroUser;
	
	@FXML 
	private Label titleCadastrDeUsuarios;
	
	@FXML 
	private Label lblDadosPessoais;
	
	@FXML 
	private Label lblDadosDeLogin;
	
	@FXML 
	private Label lblDadosDeEndereco;
	
	@FXML
	private Separator sepTop;
	
	@FXML
	private Separator sepMid;
	
	@FXML
	private Separator sepBotton;
	
	
	//Declaracao de metodos
	public void cancelarCadastro(){
		
	}
	
	public void finalizarCadastro(){
		
	}
}
