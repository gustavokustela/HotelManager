package DAO;

import Model.FuncionarioModel;
import Model.HospedeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {
	// create: parte dos dados para pessoa e parte para hospede, com a foreign
	// key = count(id) from pessoa
	public void create(HospedeModel hospede) {
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			Connection conn = dbc.openConnection();
			String sql = "insert into pessoa(nome,cpf,rg,dataNasc,endereco,telefone,sexo,isActive) "
					+ "VALUES(?,?,?,?,?,?,?,true);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, hospede.getNome());
			stmt.setString(2, hospede.getCpf());
			stmt.setString(3, hospede.getRG());
			stmt.setString(4, hospede.getDataNasc());
			stmt.setString(5, hospede.getEndereco());
			stmt.setString(6, hospede.getTelefone());
			stmt.setString(7, hospede.getSexo());
			stmt.execute();

			sql = "insert into hospede(codigoHospede,email,isEstrangeiro) "
					+ "VALUES((select codigo from pessoa where cpf like '" + hospede.getCpf() + "'),?,?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hospede.getEmail());
			stmt.setString(2, String.valueOf(hospede.isEstrangeiro()));
			stmt.execute();

			stmt.close();
			dbc.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HospedeModel read(String id) {
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			Connection conn = dbc.openConnection();
			dbc.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new HospedeModel();
	}

	public void update(HospedeModel hospede) {
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			Connection conn = dbc.openConnection();
			dbc.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(HospedeModel hospede) {
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			Connection conn = dbc.openConnection();
			dbc.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// lista para Relatório todos com flag active true
	public List<HospedeModel> listRelatorio() {
		List<HospedeModel> hospedes = new ArrayList<>();
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			Connection conn = dbc.openConnection();
			Statement stmt = conn.createStatement();
			String sql = "select nome , telefone  from hospede , pessoa  where codigoHospede = codigo and isActive = true";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				HospedeModel hospede = new HospedeModel();
				hospede.setNome(rs.getString("nome"));
				hospede.setTelefone(rs.getString("telefone"));
				
				hospedes.add(hospede);
			}
			rs.close();
			dbc.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospedes;
	}

	public List<HospedeModel> list() {
		List<HospedeModel> hospedes = new ArrayList<>();
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			Connection conn = dbc.openConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from hospede h, pessoa p where h.codigoHospede=p.codigo and p.isActive=true";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				HospedeModel hospede = new HospedeModel();
				hospede.setCodigo(rs.getInt("codigo"));
				hospede.setNome(rs.getString("nome"));
				hospede.setCpf(rs.getString("cpf"));
				hospede.setRG(rs.getString("rg"));
				hospede.setDataNasc(rs.getString("dataNasc"));
				hospede.setEndereco(rs.getString("endereco"));
				hospede.setTelefone(rs.getString("telefone"));
				hospede.setSexo(rs.getString("sexo"));
				hospede.setEstrangeiro(rs.getInt("isEstrangeiro"));
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
