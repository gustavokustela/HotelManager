package View;

import Control.FuncionarioController;
import Model.FuncionarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenciarUsuarioViewController implements Initializable{
    FuncionarioController funcionarioController = new FuncionarioController();
    private final ObservableList<FuncionarioModel> data = FXCollections.observableArrayList(funcionarioController.list());
    TableColumn nameCol = new TableColumn("Nome");
    TableColumn cpfCol = new TableColumn("CPF");
    TableColumn rgCol = new TableColumn("RG");
    TableColumn nascCol = new TableColumn("Nascimento");
    TableColumn endCol = new TableColumn("Endereço");
    TableColumn telCol = new TableColumn("Telefone");
    TableColumn sexoCol = new TableColumn("Sexo");
    TableColumn salarioCol = new TableColumn("Salario");
    TableColumn admCol = new TableColumn("Administrador");

    @FXML
    private TableView<FuncionarioModel> tableUser;

    @FXML
    private Button btnAtualizarDados;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    @FXML
    private void loadTable() {
        tableUser.getColumns().clear();
        nameCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("cpf"));
        rgCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("RG"));
        nascCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("dataNasc"));
        endCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("endereco"));
        telCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("telefone"));
        sexoCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("sexo"));
        salarioCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, Float>("salario"));
        admCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, Boolean>("isAdmin"));
        tableUser.setItems(data);
        tableUser.getColumns().addAll(nameCol, cpfCol, rgCol, nascCol, endCol, telCol, sexoCol, salarioCol, admCol);
    }
}
