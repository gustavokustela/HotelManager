package View;

import Control.HospedeController;
import Model.HospedeModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciarHospedesViewController implements Initializable {
    HospedeController hospedeController = new HospedeController();
    private final ObservableList<HospedeModel> data = FXCollections.observableArrayList(hospedeController.list());
    TableColumn nameCol = new TableColumn("Nome");
    TableColumn cpfCol = new TableColumn("CPF");
    TableColumn rgCol = new TableColumn("RG");
    TableColumn nascCol = new TableColumn("Nascimento");
    TableColumn endCol = new TableColumn("Endereço");
    TableColumn telCol = new TableColumn("Telefone");
    TableColumn sexoCol = new TableColumn("Sexo");
    TableColumn estCol = new TableColumn("Estadas");

    @FXML
    private TableView<HospedeModel> tableHospedes;

    @FXML
    private Button btnAtualizarDados;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    @FXML
    public void loadTable(){
        tableHospedes.getColumns().clear();
        nameCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("cpf"));
        rgCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("RG"));
        nascCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("dataNasc"));
        endCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("endereco"));
        telCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("telefone"));
        sexoCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("sexo"));
        estCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("qtdEstadas"));
        tableHospedes.setItems(data);
        tableHospedes.getColumns().addAll(nameCol, cpfCol, rgCol, nascCol, endCol, telCol, sexoCol, estCol);
    }
}
