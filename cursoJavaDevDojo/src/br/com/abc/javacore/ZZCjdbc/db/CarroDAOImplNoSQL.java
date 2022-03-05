package br.com.abc.javacore.ZZCjdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Carro;
import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;
import br.com.abc.javacore.ZZCjdbc.interfaces.CarroDAO;

public class CarroDAOImplNoSQL implements CarroDAO{

	@Override
	public void save(Carro carro) {
		String sql = "INSERT INTO AGENCIA.CARRO(NOME, PLACA, COMPRADOR_ID) VALUES(?, ?, ?);\n";
		
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement  ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
			ps.setString(1, carro.getNome());
			ps.setString(2, carro.getNome());
			ps.setInt(3, carro.getComprador().getId());
			ps.executeUpdate();
			System.out.println("Registro inserido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(Carro carro) {
		if(carro == null || carro.getId() == null) {
			System.out.println("Não foi possível excluir o registro.");
			return; 
		}
		String sql = "DELETE FROM AGENCIA.CARRO WHERE ID = ?;";
		
		try(Connection conn = ConexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
			ps.setInt(1, carro.getId());
			ps.executeUpdate();
			System.out.println("Registro excluído com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Carro carro) {
		if(carro == null || carro.getId() == null) {
			System.out.println("Não foi possível atualizar o registro");
			return;
		}
		String sql = "UPDATE AGENCIA.CARRO SET PLACA = ?, NOME = ? WHERE ID = ?;\n"; 
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getNome());
			ps.setInt(3, carro.getId());
			ps.executeUpdate();
			System.out.println("Registro atualizado com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Carro> selectAll() {
		String sql = "SELECT ID, NOME, PLACA, COMPRADOR_ID FROM AGENCIA.CARRO;";
		List<Carro> carroList = new ArrayList<Carro>();
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = ps.executeQuery()){		//RETORNA UMA LISTA
			while(rs.next()) {
				Comprador c = CompradorDAOImpl.searchById(rs.getInt(4));
				carroList.add(new Carro(rs.getInt(1), rs.getString(2), rs.getString(3), c));
			}
			return carroList;
		}
			
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	@Override
	public List<Carro> searchByName(String nome) {
		String sql = "SELECT ID, NOME, PLACA, COMPRADOR_ID FROM AGENCIA.CARRO WHERE NOME LIKE ?;";
		List<Carro> carroList = new ArrayList<Carro>();
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
			ps.setString(1, "'%" + nome + "%'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Comprador c = CompradorDAOImpl.searchById(rs.getInt(4));
				carroList.add(new Carro(rs.getInt(1), rs.getString(2), rs.getString(3), c));
			}
			ConexaoFactory.close(conn, ps, rs);
			return carroList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	@Override
	public Comprador searchById(Integer id) {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR WHERE ID = ?;";
		Comprador comprador = null;
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement
						(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				comprador = new Comprador(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME"));
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
