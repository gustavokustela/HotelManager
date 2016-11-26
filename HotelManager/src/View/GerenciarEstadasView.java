package View;

import Control.EstadaController;
import Model.EstadaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciarEstadasView implements Initializable {
    EstadaController estadaController = new EstadaController();
    private final ObservableList<EstadaModel> dataAll = FXCollections.observableArrayList(estadaController.listAll());
    private final ObservableList<EstadaModel> dataActive = FXCollections.observableArrayList(estadaController.listActive());
    TableColumn codCol = new TableColumn("Codigo");
    TableColumn hospCol = new TableColumn("Hospede");
    TableColumn quartoCol = new TableColumn("Quarto");
    TableColumn inCol = new TableColumn("Check-in");
    TableColumn outCol = new TableColumn("Check-out");
    TableColumn resCol = new TableColumn("Reserva");

    @FXML
    private RadioButton radActive;

    @FXML
    private RadioButton radAll;

    @FXML
    private TableView<EstadaModel> tableEstadas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTableAll();
    }

    @FXML
    private void updateTable(){
        if(radActive.isSelected()){
            loadTableActive();
        }else{
            loadTableAll();
        }
    }

    @FXML
    private void loadTableAll() {
        tableEstadas.getColumns().clear();
        codCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Long>("codigoIdentificacao"));
        hospCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("hospede"));
        quartoCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("quarto"));
        inCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("dataCheckIn"));
        outCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("dataCheckOut"));
        resCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("reserva"));
        tableEstadas.setItems(dataAll);
        tableEstadas.getColumns().addAll(codCol, hospCol, quartoCol, inCol, outCol, resCol);
        for(TableColumn column : tableEstadas.getColumns())
            column.setStyle("-fx-alignment: CENTER;");
    }

    @FXML
    private void loadTableActive() {
        tableEstadas.getColumns().clear();
        codCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Long>("codigoIdentificacao"));
        hospCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("hospede"));
        quartoCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("quarto"));
        inCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("dataCheckIn"));
        outCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, String>("dataCheckOut"));
        resCol.setCellValueFactory(new PropertyValueFactory<EstadaModel, Integer>("isReserva"));
        tableEstadas.setItems(dataActive);
        tableEstadas.getColumns().addAll(codCol, hospCol, quartoCol, inCol, outCol, resCol);
        for(TableColumn column : tableEstadas.getColumns())
            column.setStyle("-fx-alignment: CENTER;");
    }

    @FXML
    private void all(){
        loadTableAll();
    }

    @FXML
    private void active(){
        loadTableActive();
    }
}
