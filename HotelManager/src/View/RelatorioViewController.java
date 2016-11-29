package View;

import java.io.FileInputStream;
import java.io.InputStream;

import DAO.HospedeDAO;
import DAO.QuartoDAO;
import groovy.ui.SystemOutputInterceptor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;



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
	@FXML
	public void relatorioHospedes(ActionEvent event) throws Exception{
		HospedeDAO hospede = new HospedeDAO();
		
		InputStream arq = new FileInputStream("src/relatorio/RelatorioHospede.jrxml");
    	JasperReport report =  JasperCompileManager.compileReport(arq);
    	JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(hospede.listRelatorio(),false));
    	
    	JasperViewer.viewReport(print,false);
		
	}
	
	//metodo para exibicao de relatorio de despesas do hospede (apos check-out)
	@FXML
	public void relatorioDespesas(){
		
	}
	
	//metodo para exibicao de relatorio de quartos do hotel
	@FXML
	public void relatorioQuartos(ActionEvent event) throws Exception {
		
//		QuartoDAO quarto= new QuartoDAO();
//    	InputStream arq = new FileInputStream("src/relatorio/relatorioQuartos.jrxml");
//    	JasperReport report =  JasperCompileManager.compileReport(arq);
//    	JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(quarto.listRelatorio(),false));
//    	
//    	JasperViewer.viewReport(print,false);
		
	}
	
}
