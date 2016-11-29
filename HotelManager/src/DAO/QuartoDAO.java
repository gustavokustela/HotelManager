package DAO;

import Model.FuncionarioModel;
import Model.HospedeModel;
import Model.QuartoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    List<QuartoModel> quartos = new ArrayList<>();
    public void create(QuartoModel quarto){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            String sql = "insert into quarto(numero,andar,isSuiteEspecial,qtdeCamasSolteiro,qtdeCamasCasal,areaM2,valorDiaria,isActive) " +
                    "VALUES(?,?,?,?,?,?,?,true);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(quarto.getNumero()));
            stmt.setString(2, String.valueOf(quarto.getAndar()));
            stmt.setString(3, String.valueOf(quarto.getSuiteEspecial()));
            stmt.setString(4, String.valueOf(quarto.getQtdCamasSolteiro()));
            stmt.setString(5, String.valueOf(quarto.getQtdCamasCasal()));
            stmt.setString(6, String.valueOf(quarto.getAreaM2()));
            stmt.setString(7, String.valueOf(quarto.getValorDiaria()));
            stmt.execute();
            stmt.close();

            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public QuartoModel read(int numQuarto){
        QuartoModel quarto = new QuartoModel();
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from quarto where isActive=true and numero="+numQuarto;
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                quarto.setNumero(rs.getInt("numero"));
                quarto.setAndar(rs.getInt("andar"));
                quarto.setSuiteEspecial(rs.getString("isSuiteEspecial"));
                quarto.setQtdCamasSolteiro(rs.getInt("qtdeCamasSolteiro"));
                quarto.setQtdCamasCasal(rs.getInt("qtdeCamasCasal"));
                quarto.setAreaM2(rs.getFloat("areaM2"));
                quarto.setValorDiaria(rs.getFloat("valorDiaria"));
                quartos.add(quarto);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quarto;
    }
    public void update(QuartoModel quarto){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(QuartoModel quarto){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //lista todos com flag active true
    public List<QuartoModel> list(){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from quarto where isActive=true";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                QuartoModel quarto = new QuartoModel();
                quarto.setNumero(rs.getInt("numero"));
                quarto.setAndar(rs.getInt("andar"));
                quarto.setSuiteEspecial(rs.getString("isSuiteEspecial"));
                quarto.setQtdCamasSolteiro(rs.getInt("qtdeCamasSolteiro"));
                quarto.setQtdCamasCasal(rs.getInt("qtdeCamasCasal"));
                quarto.setAreaM2(rs.getFloat("areaM2"));
                quarto.setValorDiaria(rs.getFloat("valorDiaria"));
                quartos.add(quarto);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quartos;
    }
//    public List<QuartoModel> listRelatorio(){
//        List<QuartoModel> quartos = new ArrayList<>();
//        DatabaseConnection dbc = new DatabaseConnection();
//        try {
//            Connection conn = dbc.openConnection();
//            Statement stmt = conn.createStatement();
//            String sql = "select numero,andar,qtdeCamasSolteiro,qtdeCamasCasal,isSuiteEspecial from quarto where isActive=true";
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                QuartoModel quarto = new QuartoModel();
//                quarto.setNumero(rs.getInt("numero"));
//                quarto.setAndar(rs.getInt("andar"));
//                quarto.setQtdCamasSolteiro(Integer.toString((rs.getInt("qtdeCamasSolteiro"))));
//                quarto.setQtdCamasCasal(Integer.toString((rs.getInt("qtdeCamasCasal"))));
//                quarto.setSuiteEspecial(rs.getString("isSuiteEspecial"));
//                
//                quartos.add(quarto);
//            }
//            rs.close();
//            dbc.closeConnection(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return quartos;
//    }
}
