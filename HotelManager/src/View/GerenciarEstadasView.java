package View;

import Control.EstadaController;
import Model.EstadaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciarEstadasView implements Initializable {
    EstadaController estadaController = new EstadaController();
    private final ObservableList<EstadaModel> data = FXCollections.observableArrayList(estadaController.list());
    TableColumn codCol = new TableColumn("Codigo");
    TableColumn hospCol = new TableColumn("Hospede");
    TableColumn quartoCol = new TableColumn("Quarto");
    TableColumn inCol = new TableColumn("Check-in");
    TableColumn outCol = new TableColumn("Check-out");
    TableColumn resCol = new TableColumn("Reserva");

    @FXML
    private TableView tableEstadas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    @FXML
    private void loadTable() {
        tableEstadas.getColumns().clear();
        codCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("codigoIdentificacao"));
        hospCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("codHosp"));
        quartoCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("codQuarto"));
        inCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("dataCheckin"));
        outCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("dataCheckout"));
        resCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("isReserva"));
        tableEstadas.setItems(data);
        tableEstadas.getColumns().addAll(codCol, hospCol, quartoCol, inCol, outCol, resCol);
    }
}
