package View;

import Control.HospedeController;
import Model.HospedeModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenciarHospedesViewController {
    HospedeController hospedeController = new HospedeController();
    private final ObservableList<HospedeModel> data = FXCollections.observableArrayList(hospedeController.list());
    TableColumn nameCol = new TableColumn("Nome");
    TableColumn cpfCol = new TableColumn("CPF");

    public GerenciarHospedesViewController() {
        loadTable();
    }

    @FXML
    private TableView<HospedeModel> tableHospedes;

    @FXML
    private Button btnAtualizarDados;

    @FXML
    public void loadTable(){
        tableHospedes.getColumns().clear();
        nameCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("cpf"));
        tableHospedes.setItems(data);
        tableHospedes.getColumns().addAll(nameCol);
        tableHospedes.getColumns().addAll(cpfCol);
    }
}
