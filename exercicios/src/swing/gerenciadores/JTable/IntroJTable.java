package swing.gerenciadores.JTable;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IntroJTable extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel painelFundo;
//	JPanel painelFundo2;
	JTable tabela;
//	JTable tabela2;
//	JScrollPane barraRolagem2;
	JScrollPane barraRolagem;
	
	Object[][] dados = {
			{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
			{"Jo�o da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
			{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"},
			};
	
//	Object[][] dados2 = {
//			{"Rafael Souto", "61 9414-3284", "rsowtto@gmail.com"},
//			{"Israel Souto", "61 9999-3345", "israelsilva@hotmail.com"},
//			{"Bruno Sidney", "61 9206-6094", "brunoestalone@gmail.com"},
//			};
	
	String[] colunas = {"nome", "telefone", "email"};
	
	public IntroJTable() {
		//Define t�tulo da janela
		super("contatos");
	}
	
	public void criarJanela() {
		painelFundo = new JPanel();
//		painelFundo2 = new JPanel();
		painelFundo.setLayout(new GridLayout(2, 1));
//		painelFundo2.setLayout(new GridLayout(2,1));
		//Lembrar de voltar aqui e usar GrouypLayout no lugar
		//Criando o JTable fornecendo de par�metro o array e matriz
		tabela = new JTable(dados, colunas);
//		tabela2 = new JTable(dados2, colunas);
		//Criando o JScrollPane e colocando o JTable dentro.
		barraRolagem = new JScrollPane(tabela);
//		barraRolagem2 = new JScrollPane(tabela2);
		//Adicionando o JScrollPane ao pain�l
		painelFundo.add(barraRolagem);
//		painelFundo2.add(barraRolagem2);
//		painelFundo.add(painelFundo2);
		
		//Voc� pode definir o conatiner da janela como o painelFundo ou adicionar
		//v�rios componentes como v�rios JPanels
		this.getContentPane().add(painelFundo);
//		this.setContentPane(painelFundo2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 120);
		this.setVisible(true);
		this.pack();
		
	}
	
	public static void main(String[] args) {
		IntroJTable i = new IntroJTable();
		i.criarJanela();
	}

}

