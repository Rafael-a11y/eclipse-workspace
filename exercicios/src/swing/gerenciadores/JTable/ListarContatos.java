package swing.gerenciadores.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarContatos extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem ;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public ListarContatos() {
		super("Contatos");
		criaJTable();
		criaJanela();
	}
	
public void criaJTable() {
		
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("email");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
		pesquisar(modelo);
	}
	
	public void criaJanela() {
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		
		
		this.getContentPane().add(painelFundo);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 320);
		this.pack();
	 	this.setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
	}
	
	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		FrutaDAO dao = new FrutaDAO();
		
		for(Fruta c : dao.getContatos()) {
			modelo.addRow(new Object[]{c.getId(), c. getNome(), c.getTelefone(), c.getEmail()});
		}
	}
	
	private class BtInserirListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			InserirFruta ic = new InserirFruta(modelo);
			ic.setVisible(true);
		}
	}
	
	private class BtEditarListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if(linhaSelecionada >= 0) {
				//Fornece dde parâmetro a linha e o índice da coluna.
				int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
				AtualizarFruta ic = new AtualizarFruta(modelo, idContato, linhaSelecionada);
				ic.setVisible(true);
				}
			else {
				JOptionPane.showMessageDialog(null, "É nescessário selecionar uma linha");
			}
		}
	}
	
	private class BtExcluirListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if(linhaSelecionada >= 0) {
				int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
				FrutaDAO dao = new FrutaDAO();
				dao.remover(idContato);
				modelo.removeRow(linhaSelecionada);
			}
			else {
				JOptionPane.showMessageDialog(null, "É nescesário selecionar uma linha");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		new ListarContatos().setVisible(true);
	}
}
