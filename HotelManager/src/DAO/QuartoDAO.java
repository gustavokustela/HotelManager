package DAO;

import Model.FuncionarioModel;
import Model.QuartoModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    List<QuartoModel> quartos = new ArrayList<>();
    public void create(QuartoModel quarto){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public QuartoModel read(Long id){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new QuartoModel();
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
            String sql = "select * from hospede h, pessoa p where h.codigoHospede=p.codigo and p.isActive=true";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                QuartoModel quarto = new QuartoModel();
                quarto.setNumero(rs.getLong("numero"));
                quartos.add(quarto);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
