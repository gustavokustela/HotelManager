package DAO;

import Model.EstadaModel;
import Model.FuncionarioModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadaDAO {
    public void create(EstadaModel estada){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public EstadaModel read(Long id){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new EstadaModel();
    }
    public void update(EstadaModel estada){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(EstadaModel estada){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //lista todos com flag active true
    public List<EstadaModel> list(){
        List<EstadaModel> estadas = new ArrayList<>();
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada where isActive=true";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                EstadaModel estada = new EstadaModel();
                estada.setHospede(rs.getInt("codHospede"));
                estada.setQuarto(rs.getInt("codQuarto"));
                estada.setDataCheckIn(rs.getString("dataCheckin"));
                estada.setDataCheckOut(rs.getString("dataCheckout"));
                estada.setReserva(rs.getInt("isReserva"));
                estadas.add(estada);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadas;
    }
}
