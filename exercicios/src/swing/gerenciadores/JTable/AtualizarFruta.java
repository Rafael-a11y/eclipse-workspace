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

public class AtualizarFruta extends JFrame{

	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbEmail;
	private JLabel lbId;
	private JTextField txNome;
	private JTextField txId;
	private JTextField txTelefone;
	private JTextField txEmail;
	Fruta contato;
	private int linhaSelecionada;

	public AtualizarFruta(DefaultTableModel md,
	int id, int linha) {
		super("Contatos");
		criaJanela();
		modelo = md;
		FrutaDAO dao = new FrutaDAO();
		contato = dao.getContatoById(id);
		txId.setText(Integer.toString(contato.getId()));
		txNome.setText(contato.getNome());
		txTelefone.setText(contato.getTelefone());
		txEmail.setText(contato.getEmail());
		linhaSelecionada = linha;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbNome = new JLabel("         Nome.:   ");
		lbTelefone = new JLabel("         Telefone.:   ");
		lbEmail = new JLabel("         Email.:   ");
		lbId = new JLabel("         Id.:   ");
		txNome = new JTextField();
		txTelefone = new JTextField();
		txEmail = new JTextField();
		txId = new JTextField();
		txId.setEditable(false);

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(5, 2, 2, 4));
		painelFundo.add(lbId);
		painelFundo.add(txId);
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(lbEmail);
		painelFundo.add(txEmail);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);

		btSalvar.addActionListener(new
		AtualizarFruta.BtSalvarListener());
		btLimpar.addActionListener(new
		AtualizarFruta.BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Fruta c = new Fruta();
			c.setId(Integer.parseInt(txId.getText()));
			c.setNome(txNome.getText());
			c.setTelefone(txTelefone.getText());
			c.setEmail(txEmail.getText());

			FrutaDAO dao = new FrutaDAO();
			dao.atualizar(c);
			modelo.removeRow(linhaSelecionada);
			modelo.addRow(new Object[]{c.getId(),
			c.getNome(), c.getTelefone(), c.getEmail()});
			setVisible(false);
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
			txEmail.setText("");
		}
	}
}
