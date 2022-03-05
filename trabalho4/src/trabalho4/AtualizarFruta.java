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

public class AtualizarFruta extends JFrame{

	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbDescricao;
	private JLabel lbQuantidade;
	private JLabel lbId;
	private JTextField txDescricao;
	private JTextField txId;
	private JTextField txQuantidade;
	Fruta fruta;
	private int linhaSelecionada;

	public AtualizarFruta(DefaultTableModel md,
	int id, int linha) {
		super("Frutas");
		criaJanela();
		modelo = md;
		FrutaDAO dao = new FrutaDAO();
		fruta = dao.getFrutaById(id);
		txId.setText(Integer.toString(fruta.getId()));
		txDescricao.setText(fruta.getDescricao());
		txQuantidade.setText(Integer.toString(fruta.getQuantidade()));
		linhaSelecionada = linha;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		lbDescricao = new JLabel("         Descrição:   ");
		lbQuantidade = new JLabel("        Quantidade:   ");
		lbId = new JLabel("         Id.:   ");
		txDescricao = new JTextField();
		txQuantidade = new JTextField();
		txId = new JTextField();
		txId.setEditable(false);

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
		painelFundo.add(lbId);
		painelFundo.add(txId);
		painelFundo.add(lbDescricao);
		painelFundo.add(txDescricao);
		painelFundo.add(lbQuantidade);
		painelFundo.add(txQuantidade);
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
			Fruta f = new Fruta();
			f.setId(Integer.parseInt(txId.getText()));
			f.setDescricao(txDescricao.getText());
			f.setQuantidade(Integer.parseInt(txQuantidade.getText()));

			FrutaDAO dao = new FrutaDAO();
			dao.atualizar(f);
			modelo.removeRow(linhaSelecionada);
			modelo.addRow(new Object[]{f.getId(),
			f.getDescricao(), f.getQuantidade()});
			setVisible(false);
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txDescricao.setText("");
			txQuantidade.setText("");
		}
	}
}
