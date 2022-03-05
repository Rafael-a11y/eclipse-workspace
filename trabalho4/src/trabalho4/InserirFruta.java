package trabalho4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InserirFruta extends JFrame{

	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbDescricao;
	private JLabel lbQuantidade;
	private JTextField txDescricao;
	private JTextField txQuantidade;
	
	public InserirFruta(DefaultTableModel md) {
		super("Frutas");
		criaJanela();
		this.modelo = md;
	}
	
	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbDescricao = new JLabel("		Nome:	");
		lbQuantidade = new JLabel("		Quantidade:	");
		txDescricao = new JTextField(10);
		txQuantidade = new JTextField();
		
		painelFundo = new JPanel();
		//linhas, colunas, vão horizontal, vão vertical.
		painelFundo.setLayout(new GridLayout(3, 2, 2, 4));
		painelFundo.add(lbDescricao);
		painelFundo.add(txDescricao);
		painelFundo.add(lbQuantidade);
		painelFundo.add(txQuantidade);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);
		
		this.getContentPane().add(painelFundo);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 150);
		this.setVisible(true);
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
	}
	
	private class BtSalvarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Fruta f = new Fruta();
			f.setDescricao(txDescricao.getText());
			f.setQuantidade(Integer.parseInt(txQuantidade.getText()));
			
			FrutaDAO dao = new FrutaDAO();
			dao.inserir(f);
			ListarFruta.pesquisar(modelo);
			
			setVisible(false);
		}
	}
	
	private class BtLimparListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			txDescricao.setText("");
			txQuantidade.setText("");
			
		}
		
	}
}
