package View;

import Model.FuncionarioModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import Control.FuncionarioController;

public class CadastroUsuarioViewController {
	FuncionarioController funcionarioController = new FuncionarioController();
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
		mainCadastroDeUsuarios.getChildren().clear();
	}
	
	public void finalizarCadastro(){
		if(!txtBoxNomeUser.getText().isEmpty() && !txtBoxDtNascUser.getText().isEmpty() &&
				!txtBoxRgUser.getText().isEmpty() && !txtBoxCpfUser.getText().isEmpty() &&
				!txtBoxSexoUser.getText().isEmpty() && !txtBoxSalarioUser.getText().isEmpty() &&
				!txtBoxTelefoneUser.getText().isEmpty() && !txtBoxUserLogin.getText().isEmpty() &&
				!txtBoxUserPassword.getText().isEmpty() && !txtBoxEndLougradouro.getText().isEmpty() &&
				!txtBoxEndNumero.getText().isEmpty() && !txtBoxEndBairro.getText().isEmpty() &&
				!txtBoxEndCidade.getText().isEmpty() && !txtBoxEndEstado.getText().isEmpty())
		{
			FuncionarioModel funcionario = new FuncionarioModel();
			funcionario.setNome(txtBoxNomeUser.getText());
			funcionario.setDataNasc(txtBoxDtNascUser.getText());
			funcionario.setRG(txtBoxRgUser.getText());
			funcionario.setCpf(txtBoxCpfUser.getText());
			funcionario.setSexo(txtBoxSexoUser.getText());
			funcionario.setTelefone(txtBoxTelefoneUser.getText());
			funcionario.setEndereco(txtBoxEndLougradouro.getText() + ", " +
					txtBoxEndNumero.getText() + ", " + txtBoxEndBairro.getText() + ", " +
					txtBoxEndCidade.getText() + ", " + txtBoxEndEstado.getText());
			funcionario.setSalario(Float.parseFloat(txtBoxSalarioUser.getText()));
			funcionario.setUser(txtBoxUserLogin.getText());
			funcionario.setPassword(txtBoxUserPassword.getText());
			if(checkBoxIsAdminSistema.isSelected())
				funcionario.setAdmin(1);
			else
				funcionario.setAdmin(0);
			funcionarioController.create(funcionario);
			mainCadastroDeUsuarios.getChildren().clear();
		}else{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Digite todos os campos");
			alert.showAndWait();
		}
	}
}
