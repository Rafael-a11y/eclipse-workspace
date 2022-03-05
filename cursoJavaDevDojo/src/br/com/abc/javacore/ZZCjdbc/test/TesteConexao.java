package br.com.abc.javacore.ZZCjdbc.test;

import java.sql.SQLException;
import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CompradorDBOLD;

public class TesteConexao {

	public static void main(String[] args) {
//		inserir();
//		List<Comprador> listaComprador = selecionarTudo();
//		List<Comprador> listaComprador2 = buscaPorNome("maria");
//		System.out.println(listaComprador2);
//		CompradorDBOLD.selectMetaData();
//		CompradorDBOLD.checkDriverStatus();
//		inserir();
//		CompradorDBOLD.testTypeScroll();
//		CompradorDBOLD.updateNomesToLowerCase();
//		System.out.println(CompradorDBOLD.searchByNamePreparedStatement(""));
//		CompradorDBOLD.updatePreparedStatement(new Comprador(10, "999.999.999-99", "ELAYA"));
//		System.out.println(CompradorDBOLD.searchByNameCallableStatement("maria"));
//		System.out.println(CompradorDBOLD.searchByNameRowSet("lucio"));
//		CompradorDBOLD.updateRowSet(new Comprador(1, "000.000.000-11", "Rafael"));
//		CompradorDBOLD.updateRowSetCached(1);
		try {
			CompradorDBOLD.saveTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void inserir() {
		Comprador comprador = new Comprador("888.888.888-88", "Petra");
		System.out.println(comprador.getId());
		CompradorDBOLD.save(comprador);
	}
	
	public static void deletar() {
		Comprador comprador = new Comprador();
		comprador.setId(2);
		CompradorDBOLD.delete(comprador);
	}
	
	public static void atualizar() {
		Comprador comprador = new Comprador(1, "000.000.000-11", "MARIA");
		CompradorDBOLD.update(comprador);
	}
	
	public static List<Comprador> selecionarTudo() {
		return CompradorDBOLD.selectAll();
	}
	
	public static List<Comprador> buscaPorNome(String nome){
		return CompradorDBOLD.searchByName(nome);
	}
}
