package swing.gerenciadores.JTable;

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
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbEmail;
	private JTextField txNome;
	private JTextField txTelefone;
	private JTextField txEmail;
	
	public InserirFruta(DefaultTableModel md) {
		super("Contatos");
		criaJanela();
		this.modelo = md;
	}
	
	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("		Nome.:	");
		lbTelefone = new JLabel("		Telefone.:	");
		lbEmail = new JLabel("		Email.:	");
		txNome = new JTextField(10);
		txTelefone = new JTextField();
		txEmail = new JTextField();
		
		painelFundo = new JPanel();
		//linhas, colunas, vão horizontal, vão vertical.
		painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(lbEmail);
		painelFundo.add(txEmail);
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
			Fruta c = new Fruta();
			c.setNome(txNome.getText());
			c.setTelefone(txTelefone.getText());
			c.setEmail(txEmail.getText());
			
			FrutaDAO dao = new FrutaDAO();
			dao.inserir(c);
			ListarContatos.pesquisar(modelo);
			
			setVisible(false);
		}
	}
	
	private class BtLimparListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
			txEmail.setText("");
			
		}
		
	}
}
