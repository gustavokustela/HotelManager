package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Stack;

public class PrincipalViewController {
    @FXML
    private Pane menuPane;

    @FXML
    private StackPane principalPane;

    public void loadLogin() throws IOException {
        principalPane.getChildren().clear();
        Node no = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
        principalPane.getChildren().add(no);
        loadLogin();
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
