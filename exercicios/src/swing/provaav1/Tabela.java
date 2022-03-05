package swing.provaav1;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JFrame{

	JTable tabela;
	JScrollPane barraRolagem;
	JPanel painelFundo;
	DefaultTableModel modelo = new DefaultTableModel();
	
	public Tabela() {
		initialize();
	}
	public void initialize() {
		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1,1));
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Placa");
		modelo.addColumn("Marca");
		modelo.addColumn("Modelo");
		modelo.addColumn("Potência em cavalos");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		modelo.setNumRows(0);
		Barao barao = new Barao();
		 for(Carro c : barao.getCarros()) {
			 modelo.addRow(new Object[] {c.getId(), c.getMarca(), c.getModelo(), c.getPlaca(), c.getPotenciaEmCavalos()});
		 }
		 
		 barraRolagem = new JScrollPane(tabela);
		 painelFundo.add(barraRolagem);
		 
		 this.getContentPane().add(painelFundo);
		 this.setSize(500, 320);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.pack();
		
	}

}
