package br.com.abc.javacore.ZZCjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConexaoFactory {
	
	public static Connection getConexao() {
		String url = "jdbc:mysql://localhost:3306/AGENCIA?serverTimezone=UTC&useLegacyDatetimeCode=false";
		String user = "root";
		String password = "PQ@n@17";
		try {
			return  DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*Para obter um objeto de conexão RowSet, usa-se RowSetProvider, logo NewFactory() e createJdbcRowSet(), importante
	 * salientar, que se precisa setar a url, o user, e o password, depois retorne o objeto JdbcSetRow como de costume.*/
	public static JdbcRowSet getRowSetConetion() {
		String url = "jdbc:mysql://localhost:3306/AGENCIA?serverTimezone=UTC&useLegacyDatetimeCode=false?";
		String user = "root";
		String password = "PQ@n@17";
		try {
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);
			return jdbcRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static CachedRowSet getRowSetConetionCached() {
		String url = "jdbc:mysql://localhost:3306/AGENCIA?serverTimezone=UTC&useLegacyDatetimeCode=false?relaxAutoCommit=true";
		String user = "root";
		String password = "PQ@n@17";
		try {
			CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			cachedRowSet.setUrl(url);
			cachedRowSet.setUsername(user);
			cachedRowSet.setPassword(password);
			return cachedRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*Para não acontecer um NullPointerException, só tentamos fechar se ele não for nulo (:])-{*/
	public static void close(RowSet jrs){
		try {
			if(jrs != null) {
				jrs.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection connection){
		try {
			if(connection != null) {
			connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, Statement stmt) {
		close(connection);
		try {
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void close(Connection connection, Statement stmt, ResultSet rs) {
		close(connection, stmt);
		try {
				if(rs != null) {
					rs.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
	

//	public static Connection getConexao() {
//		String url = "jdbc:mysql://localhost:3306/AGENCIA?serverTimezone=UTC&useLegacyDatetimeCode=false";
//		String us	er = "root";
//		String password = "PQ@n@17";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(url, user, password);
//			System.out.println(connection);
//			return connection;
//		} catch (SQLException | ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}
