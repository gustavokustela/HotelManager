package View;

import Control.QuartoController;
import Control.EstadaController;
import Control.HospedeController;
import Model.EstadaModel;
import Model.HospedeModel;
import Model.QuartoModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.sun.prism.Image;

public class GerenciarHospedesViewController implements Initializable {
    HospedeController hospedeController = new HospedeController();
    private final ObservableList<HospedeModel> data = FXCollections.observableArrayList(hospedeController.list());
    TableColumn codCol = new TableColumn("Codigo");
    TableColumn nameCol = new TableColumn("Nome");
    TableColumn cpfCol = new TableColumn("CPF");
    TableColumn rgCol = new TableColumn("RG");
    TableColumn nascCol = new TableColumn("Nascimento");
    TableColumn endCol = new TableColumn("Endereço");
    TableColumn telCol = new TableColumn("Telefone");
    TableColumn sexoCol = new TableColumn("Sexo");
    TableColumn estCol = new TableColumn("Estadas");
    
    
    //metodos utilizados na tela de gerenciamento de Hospedes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    @FXML
    public void loadTable(){
        tableHospedes.getColumns().clear();
        codCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, Integer>("codigo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("cpf"));
        rgCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("RG"));
        nascCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("dataNasc"));
        endCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("endereco"));
        telCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("telefone"));
        sexoCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, String>("sexo"));
        estCol.setCellValueFactory(new PropertyValueFactory<HospedeModel, Integer>("qtdEstadas"));
        tableHospedes.setItems(data);
        tableHospedes.getColumns().addAll(codCol, nameCol, cpfCol, rgCol, nascCol, endCol, telCol, sexoCol, estCol);
    }

    @FXML
    public void reserva() throws IOException {
        Boolean exist = false;
        EstadaModel estada = new EstadaModel();
        EstadaController estadaController = new EstadaController();
        QuartoController quartoController = new QuartoController();
        HospedeModel hospede = tableHospedes.getSelectionModel().getSelectedItem();
        if(hospede != null){
            if(!estadaController.isActive(hospede.getCodigo())){
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Realizar reserva");
                dialog.setHeaderText("Digite o numero do quarto");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    if(estadaController.itsFree(result.get())){
                        List<QuartoModel> quartos = quartoController.list();
                        for(QuartoModel quarto : quartos){
                            if (Integer.toString(quarto.getNumero()).equals(result.get())){
                                exist = true;
                                break;
                            }
                        }
                        if(exist){
                            estada.setHospede(hospede.getCodigo());
                            estada.setQuarto(Integer.parseInt(result.get()));
                            estada.setReserva("Sim");
                            estadaController.create(estada);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Sucesso");
                            alert.setHeaderText(null);
                            alert.setContentText("Reserva realizada com sucesso!");
                            alert.showAndWait();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Atenção");
                            alert.setHeaderText(null);
                            alert.setContentText("Quarto não cadastrado no sistema.");
                            alert.showAndWait();
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Atenção");
                        alert.setHeaderText(null);
                        alert.setContentText("Este quarto é ocupado no momento. A reserva não é permitida até o check-out do mesmo.");
                        alert.showAndWait();
                    }
                }
            }else{
                if(estadaController.findReserva(hospede.getCodigo())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Atenção");
                    alert.setHeaderText(null);
                    alert.setContentText("Este hospede já realizou uma reserva.");
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Atenção");
                    alert.setHeaderText(null);
                    alert.setContentText("Este hospede já se encontra com estada ativa.");
                    alert.showAndWait();
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Você deve selecionar um hospede primeiro.");
            alert.showAndWait();
        }
    }

    @FXML
    public void checkIn() throws IOException {
        Boolean exist = false;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        EstadaModel estada = new EstadaModel();
        EstadaController estadaController = new EstadaController();
        QuartoController quartoController = new QuartoController();
        HospedeModel hospede = tableHospedes.getSelectionModel().getSelectedItem();
        if(hospede != null){
            if(!estadaController.isActive(hospede.getCodigo())){
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Realizar Check-in");
                dialog.setHeaderText("Digite o numero do quarto");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    if(estadaController.itsFree(result.get())){
                        List<QuartoModel> quartos = quartoController.list();
                        for(QuartoModel quarto : quartos){
                            if (Integer.toString(quarto.getNumero()).equals(result.get())){
                                exist = true;
                                break;
                            }
                        }
                        if(exist){
                            estada.setHospede(hospede.getCodigo());
                            estada.setQuarto(Integer.parseInt(result.get()));
                            estada.setDataCheckIn(format.format(new Date()));
                            estada.setReserva("Não");
                            estadaController.create(estada);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Sucesso");
                            alert.setHeaderText(null);
                            alert.setContentText("Check-in realizado com sucesso!");
                            alert.showAndWait();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Atenção");
                            alert.setHeaderText(null);
                            alert.setContentText("Quarto não cadastrado no sistema.");
                            alert.showAndWait();
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Atenção");
                        alert.setHeaderText(null);
                        alert.setContentText("O quarto está ocupado no momento.");
                        alert.showAndWait();
                    }
                }
            }else{
                if(estadaController.findReserva(hospede.getCodigo())){
                    estadaController.checkInReserva(hospede.getCodigo());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucesso");
                    alert.setHeaderText(null);
                    alert.setContentText("Check-in realizado com sucesso em um quarto antes reservado!");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Atenção");
                    alert.setHeaderText(null);
                    alert.setContentText("O hospede já se encontra com estada ativa.");
                    alert.showAndWait();
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Você deve selecionar um hospede primeiro.");
            alert.showAndWait();
        }
    }

    @FXML
    public void checkOut() throws ParseException {
        EstadaController estadaController = new EstadaController();
        HospedeModel hospede = tableHospedes.getSelectionModel().getSelectedItem();
        if(hospede != null){
            if(estadaController.isActive(hospede.getCodigo())){
                if(estadaController.findReserva(hospede.getCodigo())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Hospede ainda não realizou o check-in na reserva!");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Check-out realizado com sucesso!\nGastos totais: "+despesas());
                    estadaController.checkOut(hospede.getCodigo());
                    alert.setTitle("Sucesso");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atenção");
                alert.setHeaderText(null);
                alert.setContentText("Este hospede não está com estada ativa.");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Você deve selecionar um hospede primeiro.");
            alert.showAndWait();
        }
    }

    private float despesas() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        QuartoController quartoController = new QuartoController();
        EstadaController estadaController = new EstadaController();
        HospedeModel hospede = tableHospedes.getSelectionModel().getSelectedItem();
        EstadaModel estada = estadaController.read(hospede.getCodigo());
        QuartoModel quarto = quartoController.read(estada.getQuarto());
        Date checkout = new Date();
        Date checkin = format.parse(estada.getDataCheckIn());
        float despesa = quarto.getValorDiaria();
        if(checkout.getDay()-checkin.getDay()>1){
            despesa = (checkout.getDay()-checkin.getDay())*quarto.getValorDiaria();
        }
        return despesa;
    }
    
    //Declaracao de recursos disponiveis para a tela de Gerenciamento de Hospedes
    @FXML
    private Pane MainGerenciarHospedes;
    
    @FXML
    private Label titleGerenciarHospedes;
    
    @FXML
    private TextField txtBoxPesquisa;

    @FXML
    private TableView<HospedeModel> tableHospedes;
    
    @FXML
    private Button btnBusca;

    @FXML
    private Button btnAtualizarDados;
    
    @FXML
    private Button btnRealizarReserva;
    
    @FXML
    private Button btnRealizarCheckIn;
    
    @FXML
    private Button btnRealizarCheckOut;
    
    @FXML
    private ImageView imgBtnBusca;
    
    @FXML
    private ImageView imgBtnRealReserva;
    
    @FXML
    private ImageView imgBtnCheckIn;
    
    @FXML
    private ImageView imgBtnCheckOut;
    
    @FXML
    private ImageView imgBtnAtualDados;
    
    @FXML
    private ImageView imgGerenciarHospedes;
}
