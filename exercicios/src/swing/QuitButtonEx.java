package swing;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class QuitButtonEx extends JFrame{
	/**
	 * Em swing, tudo � componente, o JFrame � um componente ue agrupar� os componentes menores, comumente chamados de
	 * componentes filhos (um erro, pois falar qque um componente � filho de outro, soa como heran�a).
	 */
	private static final long serialVersionUID = 1L;

	public QuitButtonEx() {
		
		initUI();
		
	}
	
	private void initUI() {
		//JButton � filho de AbstractButton que � filho de JComponent que � filho de Container
		var quitButton = new JButton("Sair");
		var testButton = new JButton("Teste");
		//Adiciona um ouvinte que chama System.exit(0) para finalizar o programa, isso acontece atrav�s de um lambda 
		quitButton.addActionListener((evento) -> System.exit(0));
		
		createLayout(quitButton, testButton);
		
		this.setTitle("Bot�o Sair");
		//Faz a tela surgir de forma alinhada com a tela de traz, como o argumento � null (null), a tela � alinhada em rela��o
		//a tela principal do computador.
		this.setLocationRelativeTo(null);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
	
	private void createLayout(JComponent arg, JComponent arg2 ) {
		///retorna um JPanel qque � filho de JComponent que � filho de Container.
		var painelFundo = new JPanel();
		//Retorna um Container que agrpar� os componentes menores
		var pane = this.getContentPane();
		//gerenciador de layout GroupLayout, recebe de par�metro o container que agrpar� os componentes, o gerenciador de
		//layout serve para organizar tais componentes dentro do Container. O gerenciador de layout padr�o � o BorderLayout.
		//O gerenciador de layout precisa ser constru�do com o llayout de par�metro, e o layout precisa definir o gerenciador
		//de layout como par�metro
		var gl = new GroupLayout(pane);
		pane.setLayout(gl);
	//Serve para criar espa�os entre os componentes e as bordas do container, parte importante do designer da janela.
		gl.setAutoCreateContainerGaps(true);
		/*Parece que aqui criamos um eixo vertical e um horizontal, para cada eixo horizontal, uma linha de componentes � chamada
		 * e uma coluna de componenmtes tamb�m � chamada de forma paralela, mas como temos apenas um bot�o, fica mais simples.
		 * o addComponent(arg passa o componente bot�o como par�metro, este deve ser adicionado nas duas dimens�es)*/
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg));
		
		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			var ex = new QuitButtonEx();
			ex.setVisible(true);
		});
	}
}
