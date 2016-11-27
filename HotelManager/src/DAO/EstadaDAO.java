package DAO;

import Model.EstadaModel;
import Model.FuncionarioModel;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class EstadaDAO {
    public void create(EstadaModel estada){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            String sql = "insert into estada (codHospede, codQuarto, dataCheckin, isReserva, isActive) " +
                    "VALUES(?,?,?,?,true);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(estada.getHospede()));
            stmt.setString(2, String.valueOf(estada.getQuarto()));
            stmt.setString(3, estada.getDataCheckIn());
            stmt.setString(4, estada.getReserva());
            stmt.execute();
            stmt.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public EstadaModel read(int codHosp){
        DatabaseConnection dbc = new DatabaseConnection();
        EstadaModel estada = new EstadaModel();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada where isActive=true and codHospede="+codHosp;
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                estada.setCodigoIdentificacao(rs.getLong("codigoIdentificacao"));
                estada.setHospede(rs.getInt("codHospede"));
                estada.setQuarto(rs.getInt("codQuarto"));
                estada.setDataCheckIn(rs.getString("dataCheckin"));
                estada.setDataCheckOut(rs.getString("dataCheckout"));
                estada.setReserva(rs.getString("isReserva"));
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estada;
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
    public List<EstadaModel> listActive(){
        List<EstadaModel> estadas = new ArrayList<>();
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada where isActive=true and dataCheckin is not null";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                EstadaModel estada = new EstadaModel();
                estada.setCodigoIdentificacao(rs.getLong("codigoIdentificacao"));
                estada.setHospede(rs.getInt("codHospede"));
                estada.setQuarto(rs.getInt("codQuarto"));
                estada.setDataCheckIn(rs.getString("dataCheckin"));
                estada.setDataCheckOut(rs.getString("dataCheckout"));
                estada.setReserva(rs.getString("isReserva"));
                estadas.add(estada);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadas;
    }

    public List<EstadaModel> listAll(){
        List<EstadaModel> estadas = new ArrayList<>();
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                EstadaModel estada = new EstadaModel();
                estada.setCodigoIdentificacao(rs.getLong("codigoIdentificacao"));
                estada.setHospede(rs.getInt("codHospede"));
                estada.setQuarto(rs.getInt("codQuarto"));
                estada.setDataCheckIn(rs.getString("dataCheckin"));
                estada.setDataCheckOut(rs.getString("dataCheckout"));
                estada.setReserva(rs.getString("isReserva"));
                estadas.add(estada);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadas;
    }

    public boolean isActive(int hospCod){
        boolean active = false;
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada where isActive=true and codHospede = "+hospCod+";";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                active = true;
            }rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return active;
    }

    public void checkout(int hospCod){
        DatabaseConnection dbc = new DatabaseConnection();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        try {
            Connection conn = dbc.openConnection();
            String sql = "update estada set isActive=0, dataCheckout='"+format.format(new java.util.Date())+"' where codHospede = "+hospCod+" and isActive = 1;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean findReserva(int hospCod) {
        boolean reserva = false;
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada where dataCheckin is null and isActive=true and codHospede = "+hospCod+";";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                reserva = true;
            }rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    public void checkInReserva(int hospCod) {
        DatabaseConnection dbc = new DatabaseConnection();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        try {
            Connection conn = dbc.openConnection();
            String sql = "update estada set dataCheckin='"+format.format(new java.util.Date())+"' where codHospede = "+hospCod+" and isActive = 1;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean itsFree(String nroQuarto) {
        boolean free = true;
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from estada where isActive=true and codQuarto = "+nroQuarto+";";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                free = false;
            }rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return free;
    }
}
