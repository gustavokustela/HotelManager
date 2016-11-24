package DAO;

import Model.FuncionarioModel;
import Model.HospedeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {
    //create: parte dos dados para pessoa e parte para hospede, com a foreign key = count(id) from pessoa
    public void create(HospedeModel hospede){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            String sql = "insert into hospede " +
                    "(id, nome, idade, sexo, status) " +
                    "values (?,?,?,?,?);";
            /*PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, null);
            stmt.setString(2, h.getNome());
            stmt.setString(3, Integer.toString(h.getIdade()));
            stmt.setString(4, h.getSexo());
            stmt.setString(5, h.getStatus());
            boolean res = stmt.execute();*/
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
            String sql = "select * from hospede h, pessoa p where h.codigoHospede=p.codigo and p.isActive=true";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
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
