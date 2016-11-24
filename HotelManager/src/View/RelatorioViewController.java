package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class RelatorioViewController {
	
	//Declaracao de recursos (elementos) disponiveis para a tela de Cadastro de Hospede
	@FXML
	private Pane mainRelatorio;
	
	@FXML
	private ImageView imgRelatorioTitle;
	
	@FXML
	private ImageView imgRelatorioHospede;
	
	@FXML
	private ImageView imgRelatorioDespesa;
	
	@FXML
	private ImageView imgRelatorioQuarto;
	
	@FXML
	private Button btnRelHospedes;
	
	@FXML
	private Button btnRelDespesas;
	
	@FXML
	private Button btnRelQuartos;
	
	@FXML
	private Label titleCadastroRelatorio;
	
	
	//Declaracao de metodos para abertura de relatorios
	//metodo para exibicao de relatorio de hospedes cadastrados
	public void relatorioHospedes(){
		
	}
	
	//metodo para exibicao de relatorio de despesas do hospede (apos check-out)
	public void relatorioDespesas(){
		
	}
	
	//metodo para exibicao de relatorio de quartos do hotel
	public void relatorioQuartos(){
		
	}
}
