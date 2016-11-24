package DAO;

import Model.FuncionarioModel;
import Model.HospedeModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {
    //create: parte dos dados para pessoa e parte para hospede, com a foreign key = count(id) from pessoa
    public void create(HospedeModel hospede){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public HospedeModel read(String id){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HospedeModel();
    }
    public void update(HospedeModel hospede){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(HospedeModel hospede){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //lista todos com flag active true
    public List<HospedeModel> list(){
        List<HospedeModel> hospedes = new ArrayList<>();
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from pessoa p left join hospede h on h.codigoHospede=p.codigo and isActive=true";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                HospedeModel hospede = new HospedeModel();
                hospede.setNome(rs.getString("nome"));
                hospede.setCpf(rs.getString("cpf"));
                hospede.setRG(rs.getString("rg"));
                hospede.setDataNasc(rs.getString("dataNasc"));
                hospede.setEndereco(rs.getString("endereco"));
                hospede.setTelefone(rs.getString("telefone"));
                hospede.setSexo(rs.getString("sexo"));
                hospede.setEstrangeiro(rs.getBoolean("isEstrangeiro"));
                hospede.setQtdEstadas(rs.getInt("qtdeEstadas"));
                hospedes.add(hospede);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospedes;
    }
}
