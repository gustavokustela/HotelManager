package View;

import Control.FuncionarioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Stack;

public class PrincipalViewController {
    @FXML
    private Pane menuPane;

    @FXML
    private StackPane principalPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void login() throws IOException {
        if(!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            FuncionarioController funcController = new FuncionarioController();
            if(funcController.Auth(txtUser.getText(), txtPassword.getText())){
                menuBar.setDisable(false);
                principalPane.getChildren().clear();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atencao");
                alert.setHeaderText(null);
                alert.setContentText("Usuario nao esta cadastrado");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencao");
            alert.setHeaderText(null);
            alert.setContentText("Digite todos os campos");
            alert.showAndWait();
        }
    }

    @FXML
    public void loadCadHospede() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/CadastroHospedeView.fxml"));
        principalPane.getChildren().add(no);
    }

    @FXML
    public void loadGerenHospede() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/GerenciarHospedesView.fxml"));
        principalPane.getChildren().add(no);
    }

    @FXML
    public void loadCadQuarto() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/CadastroQuartosView.fxml"));
        principalPane.getChildren().add(no);
    }

    @FXML
    public void loadGerenQuarto() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/GerenciarQuartoView.fxml"));
        principalPane.getChildren().add(no);
    }

    @FXML
    public void loadCadUsuario() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/CadastroUsuarioView.fxml"));
        principalPane.getChildren().add(no);
    }

    @FXML
    public void loadGerenUsuario() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/GerenciarUsuarioView.fxml"));
        principalPane.getChildren().add(no);
    }

    @FXML
    public void loadRelatorio() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/RelatorioView.fxml"));
        principalPane.getChildren().add(no);
    }
}
