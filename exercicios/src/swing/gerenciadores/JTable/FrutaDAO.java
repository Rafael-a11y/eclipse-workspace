package swing.gerenciadores.JTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FrutaDAO {

	private final String INSERT = "INSERT INTO CONTATO (NOME, TELEFONE, EMAIL) VALUES (?,?,?)";
	private final String UPDATE = "UPDATE CONTATO SET NOME=?, TELEFONE=?, EMAIL = ? WHERE ID = ?";
	private final String DELETE = "DELETE FROM CONTATO WHERE ID =?";
	private final String LIST = "SELECT * FROM CONTATO";
	private final String LISTBYID = "SELECT * FROM CONTATO WHERE ID=?";

	public void inserir(Fruta contato) {
		if (contato != null) {
			Connection conn = null;
			try {
				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);

				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getTelefone());
				pstm.setString(3, contato.getEmail());

				pstm.execute();
				JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso");
				FabricaConexao.fechaConexao(conn, pstm);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir contato no banco de"
						+ "dados " + e.getMessage());
			}
		} else {
			System.out.println("O contato enviado por par�metro est� vazio");
		}
	}

	public void atualizar(Fruta contato) {
		if (contato != null) {
			Connection conn = null;
			try {
				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(UPDATE);

				pstm.setInt(4, contato.getId());
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getTelefone());
				pstm.setString(3, contato.getEmail());

				pstm.execute();
				JOptionPane.showMessageDialog(null, "Contato alterado com sucesso");
				FabricaConexao.fechaConexao(conn);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar contato no banco de"
						+ " dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O contato enviado por par�metro est� vazio");
		}


	}

	public void remover(int id) {
		Connection conn = null;
		try {
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE);

			pstm.setInt(1, id);

			pstm.execute();
			FabricaConexao.fechaConexao(conn, pstm);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de"
					+ "dados " + e.getMessage());
		}
	}

	public List<Fruta> getContatos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Fruta> contatos = new ArrayList<Fruta>();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Fruta contato = new Fruta();

				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
				contatos.add(contato);
			}
			FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
		}
		return contatos;
	}

	public Fruta getContatoById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Fruta contato = new Fruta();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LISTBYID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
			}
			FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
		}
		return contato;
	}
}
