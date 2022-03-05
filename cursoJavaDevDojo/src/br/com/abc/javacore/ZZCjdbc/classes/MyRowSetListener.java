package br.com.abc.javacore.ZZCjdbc.classes;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyRowSetListener implements RowSetListener{
	//Tais métodos serão implementados automaticamente, esta classe serve para manter o status
	//dos métodos sincronizados.
	//Conjunto de linhas alterado
	@Override
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("Comando execute() executado.");
	}

	//Linha alterada
	@Override
	public void rowChanged(RowSetEvent event) {
		System.out.println("Linha foi atualizada, inserida opu deletada");
		if(event.getSource() instanceof RowSet) {
			try {
				((RowSet) event.getSource()).execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	//Cursor movido
	@Override
	public void cursorMoved(RowSetEvent event) {
		System.out.println("Cursor movido.");
		
	}
}