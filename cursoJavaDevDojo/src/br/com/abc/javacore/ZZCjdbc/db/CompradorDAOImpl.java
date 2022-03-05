package br.com.abc.javacore.ZZCjdbc.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

public class CompradorDAOImpl {

	public static void save(Comprador comprador) {
		String sql = "INSERT INTO AGENCIA.COMPRADOR(CPF, NOME) VALUES(?, ?);\n";
		
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement  ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
			ps.setString(1, comprador.getCpf());
			ps.setString(2, comprador.getNome());
			ps.executeUpdate();
			System.out.println("Registro inserido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possível excluir o registro.");
			return; 
		}
		String sql = "DELETE FROM AGENCIA.COMPRADOR WHERE ID = ?;";
		
		try(Connection conn = ConexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
			ps.setInt(1, comprador.getId());
			ps.executeUpdate();
			System.out.println("Registro excluído com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possível atualizar o registro");
			return;
		}
		String sql = "UPDATE AGENCIA.COMPRADOR SET CPF = ?, NOME = ? WHERE ID = ?;\n"; 
		System.out.println("Registro atualizado com sucesso.");
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
			ps.setString(1, comprador.getCpf());
			ps.setString(2, comprador.getNome());
			ps.setInt(3, comprador.getId());
			ps.executeUpdate();
			System.out.println("Registro atualizado com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Comprador> selectAll() {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR;";
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = ps.executeQuery()){		//RETORNA UMA LISTA
			while(rs.next()) {
				compradorList.add(new Comprador(rs.getInt(1), rs.getString(3), rs.getString(2)));
			}
			return compradorList;
		}
			
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR WHERE NOME LIKE ?;";
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
			ps.setString(1, "'%" + nome + "%'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				compradorList.add(new Comprador(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConexaoFactory.close(conn, ps, rs);
			return compradorList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Comprador searchById(Integer id) {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR WHERE ID = ?;";
		Comprador comprador = null;
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				comprador = new Comprador(rs.getInt(1), rs.getString(3), rs.getString(2));
			}
			ConexaoFactory.close(conn, ps, rs);
			return comprador;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

