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

	/*Statement é o objeto que trabalha com os dados dentro do DB, é ele quem executa as instruções dos métodos.*/
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
	/*Transações estão por padrão desativadas, isso porque o método setAutoCommit() da classe Connection está por padrão true,
	 * isso significa que se você tentar fazer 5 INSERTS, cada INSERT será feito um de cada vez.
	 * Trnasação é executar comandos SQL em grupo, lembrando que para a transaction ser efetuada, a engine do Banco de
	 * Dados precisa ser InnoDB, como transaction são comandos em grupo, significa que: no quinto INSERT acontecer algum erro,
	 * todos os INSERTS anteriores são cancelados e não são executados. Para que a transaction seja efetuada, usa-se o método
	 * commit da classe Connection, e caso você queira continuar naquela conexão, mude o método setAutoCommit para true, mas
	 * caso você já tenha feito tudo o que precisa, apenas feche a conexão como de costume.
	 * Por precaução, use o método rollBack() da classe Connection, ele serve para o caso de aconteçer alguma exceção no meio
	 *  da transaction, o método rollBack() lança uma Exception, então ele precisa ser envolvido por um try/catch, o algorí-
	 *  timo volta para o estado anterior, mais precisamente antes do início da transaction (setAutoCommit(false)).
	 *  Caso você não queira voltar para o início da transaction, crie um objeto do tipo SavePoint e use-o como parâmetro
	 *  do método roolBack (rollBack(savePoint)), desta maneira, o roolBack retorna para a linha em que o SavePoint foi
	 *  criado, o objeto SavePoint é criado a partir do método setSavePoint da classe Connection.
	 *  Use o método commit() para efetuar os INSERTS de forma grupal, lembrando também que é aconselhavel usar este método
	 *  no bloco catch, logo depois do rollBack(). Nem sempre os drivers suportam mais de um SavePoint, sendo assim, você
	 *  pode usar o método release() da classe Connection, serve para reaproveitar o  objeto SavePoint, que serve de parâmetro
	 *  para o método release(). */
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
			System.out.println("Não foi possível excluir o registro.");
			return; 
		}
		String sql = "DELETE FROM AGENCIA.COMPRADOR WHERE ID = " + comprador.getId() + ";";
		Connection conn = ConexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(conn, stmt);
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
			System.out.println("Não foi possível atualizar o registro");
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
			System.out.println("Não foi possível atualizar o registro");
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
			//aGORA OS DADOS CONSULTADOS ESTÃO GRAVADOS NO OBJETO jrs, e o cursor está antes da
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
	/*Qando se trabalha com Cached, precisa chamar também o acceptChanges()*/
	public static void updateRowSetCached(int id) {
//		if(comprador == null || comprador.getId() == null) {
//			System.out.println("Não foi possível atualizar o registro");
//			return;
//		}
//		String sql = "UPDATE AGENCIA.COMPRADOR SET CPF = ? , NOME = ?  WHERE ID = ?;";
		String sql = "SELECT* FROM COMPRADOR WHERE ID = ?;";
		CachedRowSet crs = ConexaoFactory.getRowSetConetionCached();
		try {
			crs.setCommand(sql);
			crs.setInt(1, id);
			//aGORA OS DADOS CONSULTADOS ESTÃO GRAVADOS NO OBJETO jrs, e o cursor está antes da
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
	/*PreparedStatement extends Statement, serve para ter uma melhor performance, já é pré compilado, porém, antes de dar
	 * o comando de execução, deve-se setar a String com setString(), e o executeQuery é sem parâmetro, já que o mesmo é
	 * fornecido na criação do objeto PreparedStatement*/
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
	/*Cria o objeto JdbcRowSet, depois sete o comando a partir do método setCommand(sql), depois ao invés de criar um
	 * Statement ou PreparedStatement, sete a String a partir do método sobrecarregado setString, o que muda é o objeto que
	 * o chama, depois ao invés um ResultSet, apenas chame o método execute(). Lembrando que com JdbcRowSet, você pode
	 * apenas fazer querys, depois feche a conexão JdbcRowSet. */
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
	/*CallableStatement extends Statement, serve para poder chamar Stored Procedures e funções, lembrando que tais funções
	 * (e procedures) precisam já existir no banco de dados. É que nem o PreparedStatement, mas o método que o cria é o
	 * prepareCall(sql) já com a String fornecida, e se deve setar a String antes também e por último chamar o executeQuery */
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
	
	/*Mostra os metadados do Banco de Dados, serve para quando você não ter acesso ao WorkBench, e precisa saber as
	 * informações dos dados, como bancos presentes, suas tabelas, número de colunas etc.*/
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
	 * TYPE SCROLL INSENSITIVE -> qUANDO VOCÊ PODE MOVER O CURSOR PARA FRENTE E PARA TRÁS OU ATÉ COMEÇANDO DE UM REGISTRO 
	 * ESPECÍFICO, CASO UMA MUDANÇA SEJA FEITA NO BANCO DE DADOS, TAL MUDANÇA NÃO SERÁ REFLETIDA NO CONJUNTO DE RESULTADOS
	 * TYPE SCROLL SENSITIVE -> É O CASO CONTRÁRIO DO ANTERIOR, CASO UMA MUDANÇA SEJA FEITA NO BANCO DE DADOS ENQUANTO O
	 * CONJUNTO DE REESULTADOS É PERCORRIDO E GERADO, TAL MUDANÇA É REFLETIDA NA MESMA HORA.
	 * Este método verifica se os drivers abaixos são suportados.*/
	public static void checkDriverStatus() {
		Connection conn = ConexaoFactory.getConexao();
		try {
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			if(dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
				System.out.println("Suporta TYPE FORWARD ONLY");
				if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("E também suporta o CONCUR_UPDATABLE");
			 	}
			}
			if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.println("Suporta o TYPE_SCROLL INSENSITIVE");
				if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("E tanbém suporta o CONCUR_UPDATABLE");
				}
			}
			if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.println("Suporta o TYPE SCROL SENSITIVE.");
				if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("E também o CONCUR UPDATABLE.");
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
//			Retorna um ResultSet que pode ser percorrido como uma lista ou até servir de parâmetro para uma lista,
//			rs guarda este Result Set.
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.last()) {
				//O objeto do tipo ResultSet possui métodos para recuperar valores das colunas na tupla. 
				System.out.println("Última linha " + new Comprador
						(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
				System.out.println("Número última linha: " + rs.getRow());
			}
			//Move o cursor para a primeira linha deste objeto ResultObject
			System.out.println("Retornou para a primeira linha? " + rs.first());
//			Retorna o número da linha atual.
			System.out.println("Primeira linha: " + rs.getRow());
//			Move para a linha equivalente ao número fornecido
			rs.absolute(4);
			System.out.println("Linha " + rs.getRow() + ": " + new Comprador(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
			/*Move para linha equivalente a soma ou subtração do número fornecido. Exemplo: rs.relative(2) = mover duas
			 * linhas à baixo, rs.relative(-1) move para 1 linha a cima da linha atual.*/
			rs.relative(-1);
			System.out.println("Linha " + rs.getRow() + " : " + new Comprador
					(rs.getInt("ID"), rs.getString("CPF"), rs.getString("NOME")));
			/*Para checar a posição do cursor sem mover*/
			System.out.println("Para checar a poosição do cursr sem ter que movê-lo.");
			System.out.println("Está na última linha? " + rs.isLast());
			System.out.println("Está na primeira linha? " + rs.isFirst());
			System.out.println("Está após a última linha? " + rs.isAfterLast());
			//Move para após a última linha
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
			System.out.println("Atualizações detectadas? " + dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Inserções detectadas? " + dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Exclusões detectadas? " + dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			if(rs.next()) {
				/*Atualiza o campo no ResultSet, não no BD, é importante lembrar disso. Como o getString() retorna o valor
				 * da coluna da tupla em String, usa-se o toLowerCase()*/
				rs.updateString(("NOME"), rs.getString("NOME").toUpperCase());
				/*updateRow() serve para atualizar o banco de dados adjacente com o conteúdo da linha deste objeto ResultSet.*/
//				rs.cancelRowUpdates() pode ser usado para cancelar as alterações que foram feitas, mas deve ser chamado antes
//				do updateRow(), pois uma vez que as alterações são feitas, não há como volltar ao que era antes, por isso é bom
//				usar um if() para determinada condição e a partir daí, usar o cancelRowUpdates().				
				rs.updateRow();
			}
			/*Para inserir registros usando ResultSet -> rs.absolute(2) move para a linha 2, variável nome captura o conteúdo
			 * da linha (o nome joao), rs.moveToInsertRow() move para depois da última linha para criar um registro, após isso,
			 * rs.updateString() serve para inserir o conteúdo da variável nome com caixa elevada (nometoUpperCase()), logo
			 * após, repetimos o processo na mesma linha só que na coluna CPF, e depois para de fato inserirmos o conteúdo e
			 * criarmos a nova linha com o registro que construímos, usamos o insertRow, e logo após o moveToCurrentRow para
			 * voltar para a linha anterior que foi memorizada. Só se pode chamar insertRow() se o cursor ainda estiver na
			 * linha de inserção, caso você saia da linha antes, as atualizações não serão efetivadas*/
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
//			rs.beforeFirst() serve paraa mover o cursor para antes da primeira linha, assim você pode fazer um while()
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
//			System.out.println("Atualizações detectadas? " + dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//			System.out.println("Inserções detectadas? " + dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//			System.out.println("Exclusões detectadas? " + dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
//			if(rs.next()) {
//				/*Atualiza o campo no ResultSet, não no BD, é importante lembrar disso. Como o getString() retorna o valor
//				 * da coluna da tupla em String, usa-se o toLowerCase()*/
//				rs.updateString(("NOME"), rs.getString("NOME").toUpperCase());
//				/*updateRow() serve para atualizar o banco de dados adjacente com o conteúdo da linha deste objeto ResultSet.*/
//				rs.updateRow();
////				rs.beforeFirst() serve paraa mover o cursor para antes da primeira linha, assim você pode fazer um while()
////				junto de um syso com um rs.getString("NOME") para verificar se os nomes de fato foram convertidos para lower
//			}
//			ConexaoFactory.close(conn, stmt, rs);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}