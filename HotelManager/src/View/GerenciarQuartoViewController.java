package View;

import Control.QuartoController;
import Model.QuartoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciarQuartoViewController implements Initializable{
    QuartoController quartoController = new QuartoController();
    private final ObservableList<QuartoModel> data = FXCollections.observableArrayList(quartoController.list());
    @FXML
    private TableView<QuartoModel> tableQuartos;

    @FXML
    private Button btnAtualizarDados;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    @FXML
    private void loadTable() {
    }
}
