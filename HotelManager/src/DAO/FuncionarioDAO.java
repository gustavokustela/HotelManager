package DAO;

import Model.FuncionarioModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    //create: parte dos dados para pessoa e parte para funcionario, com a foreign key = count(id) from pessoa
    public void create(FuncionarioModel funcionario){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public FuncionarioModel read(Long id){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new FuncionarioModel();
    }
    public void update(FuncionarioModel funcionario){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(FuncionarioModel funcionario){
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //lista todos com flag active true
    public List<FuncionarioModel> list(){
        List<FuncionarioModel> funcionarios = new ArrayList<>();
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from funcionario f, pessoa p where f.codigoFunc=p.codigo and p.isActive=true";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRG(rs.getString("rg"));
                funcionario.setDataNasc(rs.getString("dataNasc"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setSalario(rs.getFloat("salario"));
                funcionario.setAdmin(rs.getBoolean("isAdmin"));
                funcionarios.add(funcionario);
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
    public boolean Auth(String user, String pwd){
        boolean valid=false;
        DatabaseConnection dbc = new DatabaseConnection();
        try {
            Connection conn = dbc.openConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from funcionario where user like '"+user+"' and password like '"+pwd+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                String codigoFunc = rs.getString("codigoFunc");
                valid = true;
            }
            rs.close();
            dbc.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
}
