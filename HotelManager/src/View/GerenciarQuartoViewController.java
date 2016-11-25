package View;

import Control.QuartoController;
import Model.QuartoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciarQuartoViewController implements Initializable{
    QuartoController quartoController = new QuartoController();
    private final ObservableList<QuartoModel> data = FXCollections.observableArrayList(quartoController.list());
    TableColumn diariaCol = new TableColumn("Diaria");
    TableColumn numCol = new TableColumn("Numero");
    TableColumn andarCol = new TableColumn("Andar");
    TableColumn suiteCol = new TableColumn("Suite");
    TableColumn soltCol = new TableColumn("Camas de solteiro");
    TableColumn casalCol = new TableColumn("Camas de casal");
    TableColumn areaCol = new TableColumn("Area m2");

    //metodos utilizados na tela de gerenciamento de Quatos
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    @FXML
    private void loadTable() {
        tableQuartos.getColumns().clear();
        diariaCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Float>("valorDiaria"));
        numCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Integer>("numero"));
        andarCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Integer>("andar"));
        suiteCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Boolean>("isSuiteEspecial"));
        soltCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Integer>("qtdeCamasSolteiro"));
        casalCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Integer>("qtdeCamasCasal"));
        areaCol.setCellValueFactory(new PropertyValueFactory<QuartoModel, Float>("areaM2"));
        tableQuartos.setItems(data);
        tableQuartos.getColumns().addAll(diariaCol, numCol, andarCol, suiteCol, soltCol, casalCol, areaCol);
    }
    
    @FXML
    public void buscar(){
    	
    }
    
    //Declaracao de recursos disponiveis para a tela de Gerenciamento de Quartos
    @FXML
    private TableView<QuartoModel> tableQuartos;
    
    @FXML
    private Pane mainGerenciarQuartos;
    
    @FXML
    private TextField txtPesquisa;

    @FXML
    private Button btnAtualizarDados;
    
    @FXML
    private Button btnBusca;
    
    @FXML
    private ImageView imgGerenciarQuartos;
    
    @FXML
    private ImageView imgBtnAtlzDados;
    
    @FXML
    private ImageView imgBtnBusca;
    
    @FXML
    private Label titleGerenciarQuartos;
}
