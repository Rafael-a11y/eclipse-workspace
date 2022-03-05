package br.com.abc.javacore.ZZCjdbc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.classes.MyRowSetListener;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

public class CompradorDBOLD {

	/*Statement � o objeto que trabalha com os dados dentro do DB, � ele quem executa as instru��es dos m�todos.*/
	public static void save(Comprador comprador) {
		String sql = "INSERT INTO AGENCIA.COMPRADOR(CPF, NOME) VALUES('" + comprador.getCpf() + "', '" + comprador.getNome() + "');\n";
		Connection conn = ConexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(conn, stmt);
			System.out.println("Registro inserido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*Transa��es est�o por padr�o desativadas, isso porque o m�todo setAutoCommit() da classe Connection est� por padr�o true,
	 * isso significa que se voc� tentar fazer 5 INSERTS, cada INSERT ser� feito um de cada vez.
	 * Trnasa��o � executar comandos SQL em grupo, lembrando que para a transaction ser efetuada, a engine do Banco de
	 * Dados precisa ser InnoDB, como transaction s�o comandos em grupo, significa que: no quinto INSERT acontecer algum erro,
	 * todos os INSERTS anteriores s�o cancelados e n�o s�o executados. Para que a transaction seja efetuada, usa-se o m�todo
	 * commit da classe Connection, e caso voc� queira continuar naquela conex�o, mude o m�todo setAutoCommit para true, mas
	 * caso voc� j� tenha feito tudo o que precisa, apenas feche a conex�o como de costume.
	 * Por precau��o, use o m�todo rollBack() da classe Connection, ele serve para o caso de aconte�er alguma exce��o no meio
	 *  da transaction, o m�todo rollBack() lan�a uma Exception, ent�o ele precisa ser envolvido por um try/catch, o algor�-
	 *  timo volta para o estado anterior, mais precisamente antes do in�cio da transaction (setAutoCommit(false)).
	 *  Caso voc� n�o queira voltar para o in�cio da transaction, crie um objeto do tipo SavePoint e use-o como par�metro
	 *  do m�todo roolBack (rollBack(savePoint)), desta maneira, o roolBack retorna para a linha em que o SavePoint foi
	 *  criado, o objeto SavePoint � criado a partir do m�todo setSavePoint da classe Connection.
	 *  Use o m�todo commit() para efetuar os INSERTS de forma grupal, lembrando tamb�m que � aconselhavel usar este m�todo
	 *  no bloco catch, logo depois do rollBack(). Nem sempre os drivers suportam mais de um SavePoint, sendo assim, voc�
	 *  pode usar o m�todo release() da classe Connection, serve para reaproveitar o  objeto SavePoint, que serve de par�metro
	 *  para o m�todo release(). */
	public static void saveTransaction() throws SQLException {
		String sql1 = "INSERT INTO AGENCIA.COMPRADOR(CPF, NOME) VALUES('TESTE1', 'TESTE1');\n";
		String sql2 = "INSERT INTO AGENCIA.COMPRADOR(CPF, NOME) VALUES('TESTE2', 'TESTE2');\n";
		String sql3 = "INSERT INTO AGENCIA.COMPRADOR(CPF, NOME) VALUES('TESTE3', 'TESTE3');\n";
		Connection conn = ConexaoFactory.getConexao();
		Savepoint savePoint = null;
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql1);
			savePoint = conn.setSavepoint("One");
			conn.releaseSavepoint(savePoint);
			stmt.executeUpdate(sql2);
			if(true)
				throw new SQLException();
			stmt.executeUpdate(sql3);
			conn.commit();
			ConexaoFactory.close(conn, stmt);
			System.out.println("Registro inserido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback(savePoint);
			conn.commit();
		}
	}
	
	public static void delete(Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("N�o foi poss�vel excluir o registro.");
			return; 
		}
		String sql = "DELETE FROM AGENCIA.COMPRADOR WHERE ID = " + comprador.getId() + ";";
		Connection conn = ConexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(conn, stmt);
			System.out.println("Registro exclu�do com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("N�o foi poss�vel atualizar o registro");
			return;
		}
		String sql = "UPDATE AGENCIA.COMPRADOR SET CPF = '"+ comprador.getCpf() + "', NOME = '" 
		+ comprador.getNome() + "' WHERE ID = '" + comprador.getId() + "';";
		Connection conn = ConexaoFactory.getConexao();
		System.out.println("Registro atualizado com sucesso.");
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(conn, stmt);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updatePreparedStatement(Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("N�o foi poss�vel atualizar o registro");
			return;
		}
		String sql = "UPDATE AGENCIA.COMPRADOR SET CPF = ? , NOME = ?  WHERE ID = ?;";
		Connection conn = ConexaoFactory.getConexao();
		try {
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, comprador.getCpf());
			ps.setString(2, comprador.getNome());
			ps.setInt(3, comprador.getId());
			ps.executeUpdate();
			ConexaoFactory.close(conn, ps);
			System.out.println("Registro atualizado com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateRowSet(Comprador comprador) {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("N�o foi poss�vel atualizar o registro");
			return;
		}
//		String sql = "UPDATE AGENCIA.COMPRADOR SET CPF = ? , NOME = ?  WHERE ID = ?;";
		String sql = "SELECT* FROM AGENCIA.COMPRADOR WHERE ID = ?;";
		JdbcRowSet jrs = ConexaoFactory.getRowSetConetion();
		jrs.addRowSetListener(new MyRowSetListener());
		try {
			jrs.setCommand(sql);
//			jrs.setString(1, comprador.getCpf());
//			jrs.setString(2, comprador.getNome());
			jrs.setInt(1, comprador.getId());
			//aGORA OS DADOS CONSULTADOS EST�O GRAVADOS NO OBJETO jrs, e o cursor est� antes da
			//linha 1, por isso o uso do execute().
			jrs.execute();
			jrs.next();
			jrs.updateString("CPF", comprador.getCpf());
			jrs.updateString("NOME", comprador.getNome());
			jrs.updateRow();
			ConexaoFactory.close(jrs);
			System.out.println("Registro atualizado com sucesso.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/*Qando se trabalha com Cached, precisa chamar tamb�m o acceptChanges()*/
	public static void updateRowSetCached(int id) {
//		if(comprador == null || comprador.getId() == null) {
//			System.out.println("N�o foi poss�vel atualizar o registro");
//			return;
//		}
//		String sql = "UPDATE AGENCIA.COMPRADOR SET CPF = ? , NOME = ?  WHERE ID = ?;";
		String sql = "SELECT* FROM COMPRADOR WHERE ID = ?;";
		CachedRowSet crs = ConexaoFactory.getRowSetConetionCached();
		try {
			crs.setCommand(sql);
			crs.setInt(1, id);
			//aGORA OS DADOS CONSULTADOS EST�O GRAVADOS NO OBJETO jrs, e o cursor est� antes da
			//linha 1, por isso o uso do execute().
			crs.execute();
			crs.next();
			crs.updateString("NOME", "WWWW");
			crs.updateRow();
			crs.acceptChanges();
			Thread.sleep(8000);
			System.out.println("Registro atualizado com sucesso.");
		}
		catch(SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Comprador> selectAll() {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR;";
		Connection conn = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);//RETORNA UMA LISTA
			while(rs.next()) {
				compradorList.add(new Comprador(rs.getInt(1), rs.getString(3), rs.getString(2)));
			}
			ConexaoFactory.close(conn, stmt, rs);
			return compradorList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR WHERE NOME LIKE '%" + nome + "%';";
		Connection conn = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);//RETORNA UMA LISTA
			while(rs.next()) {
				compradorList.add(new Comprador(rs.getInt(1), rs.getString(3), rs.getString(2)));
			}
			ConexaoFactory.close(conn, stmt, rs);
			return compradorList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*PreparedStatement extends Statement, serve para ter uma melhor performance, j� � pr� compilado, por�m, antes de dar
	 * o comando de execu��o, deve-se setar a String com setString(), e o executeQuery � sem par�metro, j� que o mesmo �
	 * fornecido na cria��o do objeto PreparedStatement*/
	public static List<Comprador> searchByNamePreparedStatement(String nome) {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR WHERE NOME LIKE ?;";
		Connection conn = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();//RETORNA UMA LISTA
			while(rs.next()) {
				compradorList.add(new Comprador(rs.getInt(1), rs.getString(3), rs.getString(2)));
			}
			ConexaoFactory.close(conn, ps, rs);
			return compradorList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*Cria o objeto JdbcRowSet, depois sete o comando a partir do m�todo setCommand(sql), depois ao inv�s de criar um
	 * Statement ou PreparedStatement, sete a String a partir do m�todo sobrecarregado setString, o que muda � o objeto que
	 * o chama, depois ao inv�s um ResultSet, apenas chame o m�todo execute(). Lembrando que com JdbcRowSet, voc� pode
	 * apenas fazer querys, depois feche a conex�o JdbcRowSet. */
	public static List<Comprador> searchByNameRowSet(String nome) {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR WHERE NOME LIKE ?;";
		JdbcRowSet jrs = ConexaoFactory.getRowSetConetion();
		jrs.addRowSetListener(new MyRowSetListener());
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try {
			jrs.setCommand(sql);
			jrs	.setString(1, "%" + nome + "%");
			jrs.execute();//RETORNA UMA LISTA
			while(jrs.next()) {
				compradorList.add(new Comprador(jrs.getInt(1), jrs.getString(3), jrs.getString(2)));
			}
			ConexaoFactory.close(jrs);
			return compradorList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*CallableStatement extends Statement, serve para poder chamar Stored Procedures e fun��es, lembrando que tais fun��es
	 * (e procedures) precisam j� existir no banco de dados. � que nem o PreparedStatement, mas o m�todo que o cria � o
	 * prepareCall(sql) j� com a String fornecida, e se deve setar a String antes tamb�m e por �ltimo chamar o executeQuery */
	public static List<Comprador> searchByNameCallableStatement(String nome) {
		String sql = "CALL AGENCIA.SP_GetCompradoresPorNome(?);";
		Connection conn = ConexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<Comprador>();
		try {
			CallableStatement cs = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cs.setString(1, "%" + nome + "%");
			ResultSet rs = cs.executeQuery();//RETORNA UMA LISTA
			while(rs.next()) {
				compradorList.add(new Comprador(rs.getInt(1), rs.getString(3), rs.getString(2)));
			}
			ConexaoFactory.close(conn, cs, rs);
			return compradorList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*Mostra os metadados do Banco de Dados, serve para quando voc� n�o ter acesso ao WorkBench, e precisa saber as
	 * informa��es dos dados, como bancos presentes, suas tabelas, n�mero de colunas etc.*/
	public static void 	selectMetaData() {
		String sql = "SELECT * FROM AGENCIA.COMPRADOR;";
		Connection conn = ConexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();//Usa-se while caso queira percorrer os registros
			int qtdColunas = rsmd.getColumnCount();
			System.out.println("Quantidade de colunas: " + qtdColunas);
			for(int i = 1; i <=qtdColunas; i++) {
				System.out.println("Tabela: " + rsmd.getTableName(i));
				System.out.println("Nome da coluna: " + rsmd.getColumnName(i));
				System.out.println("Tamanho da coluna: " + rsmd.getColumnDisplaySize(i));
			}
			ConexaoFactory.close(conn, stmt, rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/* TYPE FORWARD ONLY -> Anda de cima para baixo somente.
	 * CONCUR UPDATABLE -> Se ele consegue atualizar registros enquanto percorre os registros sem precisar usar uma Query.
	 * TYPE SCROLL INSENSITIVE -> qUANDO VOC� PODE MOVER O CURSOR PARA FRENTE E PARA TR�S OU AT� COME�ANDO DE UM REGISTRO 
	 * ESPEC�FICO, CASO UMA MUDAN�A SEJA FEITA NO BANCO DE DADOS, TAL MUDAN�A N�O SER� REFLETIDA NO CONJUNTO DE RESULTADOS
	 * TYPE SCROLL SENSITIVE -> � O CASO CONTR�RIO DO ANTERIOR, CASO UMA MUDAN�A SEJA FEITA NO BANCO DE DADOS ENQUANTO O
	 * CONJUNTO DE REESULTADOS � PERCORRIDO E GERADO, TAL MUDAN�A � REFLETIDA NA MESMA HORA.
	 * Este m�todo verifica se os drivers abaixos s�o suportados.*/
	public static void checkDriverStatus() {
		Connection conn = ConexaoFactory.getConexao();
		try {
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			if(dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
				System.out.println("Suporta TYPE FORWARD ONLY");
				if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("E tamb�m suporta o CONCUR_UPDATABLE");
			 	}
			}
			if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.println("Suporta o TYPE_SCROLL INSENSITIVE");
				if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("E tanb�m suporta o CONCUR_UPDATABLE");
				}
			}
			if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.println("Suporta o TYPE SCROL SENSITIVE.");
				if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("E tamb�m o CONCUR UPDATABLE.");
				}
			}
			ConexaoFactory.close(conn);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void testTypeScroll() {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR;";
		Connection conn = ConexaoFactory.getConexao();
		try {
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			Retorna um ResultSet que pode ser percorrido como uma lista ou at� servir de par�metro para uma lista,
//			rs guarda este Result Set.
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.last()) {
				//O objeto do tipo ResultSet possui m�todos para recuperar valores das colunas na tupla. 
				System.out.println("�ltima linha " + new Comprador
						(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
				System.out.println("N�mero �ltima linha: " + rs.getRow());
			}
			//Move o cursor para a primeira linha deste objeto ResultObject
			System.out.println("Retornou para a primeira linha? " + rs.first());
//			Retorna o n�mero da linha atual.
			System.out.println("Primeira linha: " + rs.getRow());
//			Move para a linha equivalente ao n�mero fornecido
			rs.absolute(4);
			System.out.println("Linha " + rs.getRow() + ": " + new Comprador(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
			/*Move para linha equivalente a soma ou subtra��o do n�mero fornecido. Exemplo: rs.relative(2) = mover duas
			 * linhas � baixo, rs.relative(-1) move para 1 linha a cima da linha atual.*/
			rs.relative(-1);
			System.out.println("Linha " + rs.getRow() + " : " + new Comprador
					(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
			/*Para checar a posi��o do cursor sem mover*/
			System.out.println("Para checar a poosi��o do cursr sem ter que mov�-lo.");
			System.out.println("Est� na �ltima linha? " + rs.isLast());
			System.out.println("Est� na primeira linha? " + rs.isFirst());
			System.out.println("Est� ap�s a �ltima linha? " + rs.isAfterLast());
			//Move para ap�s a �ltima linha
			rs.afterLast();
			System.out.println("--------------------------------------------Caminho inverso -> previous()-------"
					+ "--------------------------------");
			while(rs.previous()) {
				System.out.println(new Comprador(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
			}
			rs.first();
			
			ConexaoFactory.close(conn, stmt, rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//Fazendo Update com ResultSet -> Serve para organizar os dados presentes nas colunas
	public static void updateNomesToLowerCase() {
		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR;";
		Connection conn = ConexaoFactory.getConexao();
		try {
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Atualiza��es detectadas? " + dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Inser��es detectadas? " + dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Exclus�es detectadas? " + dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			if(rs.next()) {
				/*Atualiza o campo no ResultSet, n�o no BD, � importante lembrar disso. Como o getString() retorna o valor
				 * da coluna da tupla em String, usa-se o toLowerCase()*/
				rs.updateString(("NOME"), rs.getString("NOME").toUpperCase());
				/*updateRow() serve para atualizar o banco de dados adjacente com o conte�do da linha deste objeto ResultSet.*/
//				rs.cancelRowUpdates() pode ser usado para cancelar as altera��es que foram feitas, mas deve ser chamado antes
//				do updateRow(), pois uma vez que as altera��es s�o feitas, n�o h� como volltar ao que era antes, por isso � bom
//				usar um if() para determinada condi��o e a partir da�, usar o cancelRowUpdates().				
				rs.updateRow();
			}
			/*Para inserir registros usando ResultSet -> rs.absolute(2) move para a linha 2, vari�vel nome captura o conte�do
			 * da linha (o nome joao), rs.moveToInsertRow() move para depois da �ltima linha para criar um registro, ap�s isso,
			 * rs.updateString() serve para inserir o conte�do da vari�vel nome com caixa elevada (nometoUpperCase()), logo
			 * ap�s, repetimos o processo na mesma linha s� que na coluna CPF, e depois para de fato inserirmos o conte�do e
			 * criarmos a nova linha com o registro que constru�mos, usamos o insertRow, e logo ap�s o moveToCurrentRow para
			 * voltar para a linha anterior que foi memorizada. S� se pode chamar insertRow() se o cursor ainda estiver na
			 * linha de inser��o, caso voc� saia da linha antes, as atualiza��es n�o ser�o efetivadas*/
			rs.absolute(2);
			String nome = rs.getString("NOME");
			rs.moveToInsertRow();
			rs.updateString("NOME", nome.toUpperCase());
			rs.updateString("CPF", "999.999.999-99");
			rs.moveToCurrentRow();
			rs.insertRow();
			System.out.println(rs.getString("NOME") + " row " + rs.getRow());
			
//			rs.absolute(9);rs.deleteRow();
//			rs.absolute(10);rs.deleteRow();
//			rs.beforeFirst() serve paraa mover o cursor para antes da primeira linha, assim voc� pode fazer um while()
//			junto de um syso com um rs.getString("NOME") para verificar se os nomes de fato foram convertidos para lower.;
			ConexaoFactory.close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void updateNomesToUpperCase() {
//		String sql = "SELECT ID, NOME, CPF FROM AGENCIA.COMPRADOR;";
//		Connection conn = ConexaoFactory.getConexao();
//		try {
//			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
//			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = stmt.executeQuery(sql);
//			System.out.println("Atualiza��es detectadas? " + dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//			System.out.println("Inser��es detectadas? " + dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//			System.out.println("Exclus�es detectadas? " + dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//			if(rs.next()) {
//				/*Atualiza o campo no ResultSet, n�o no BD, � importante lembrar disso. Como o getString() retorna o valor
//				 * da coluna da tupla em String, usa-se o toLowerCase()*/
//				rs.updateString(("NOME"), rs.getString("NOME").toUpperCase());
//				/*updateRow() serve para atualizar o banco de dados adjacente com o conte�do da linha deste objeto ResultSet.*/
//				rs.updateRow();
////				rs.beforeFirst() serve paraa mover o cursor para antes da primeira linha, assim voc� pode fazer um while()
////				junto de um syso com um rs.getString("NOME") para verificar se os nomes de fato foram convertidos para lower
//			}
//			ConexaoFactory.close(conn, stmt, rs);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}