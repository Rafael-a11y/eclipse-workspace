package swing;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class QuitButtonEx extends JFrame{
	/**
	 * Em swing, tudo é componente, o JFrame é um componente ue agrupará os componentes menores, comumente chamados de
	 * componentes filhos (um erro, pois falar qque um componente é filho de outro, soa como herança).
	 */
	private static final long serialVersionUID = 1L;

	public QuitButtonEx() {
		
		initUI();
		
	}
	
	private void initUI() {
		//JButton é filho de AbstractButton que é filho de JComponent que é filho de Container
		var quitButton = new JButton("Sair");
		var testButton = new JButton("Teste");
		//Adiciona um ouvinte que chama System.exit(0) para finalizar o programa, isso acontece através de um lambda 
		quitButton.addActionListener((evento) -> System.exit(0));
		
		createLayout(quitButton, testButton);
		
		this.setTitle("Botão Sair");
		//Faz a tela surgir de forma alinhada com a tela de traz, como o argumento é null (null), a tela é alinhada em relação
		//a tela principal do computador.
		this.setLocationRelativeTo(null);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
	
	private void createLayout(JComponent arg, JComponent arg2 ) {
		///retorna um JPanel qque é filho de JComponent que é filho de Container.
		var painelFundo = new JPanel();
		//Retorna um Container que agrpará os componentes menores
		var pane = this.getContentPane();
		//gerenciador de layout GroupLayout, recebe de parâmetro o container que agrpará os componentes, o gerenciador de
		//layout serve para organizar tais componentes dentro do Container. O gerenciador de layout padrão é o BorderLayout.
		//O gerenciador de layout precisa ser construído com o llayout de parâmetro, e o layout precisa definir o gerenciador
		//de layout como parâmetro
		var gl = new GroupLayout(pane);
		pane.setLayout(gl);
	//Serve para criar espaços entre os componentes e as bordas do container, parte importante do designer da janela.
		gl.setAutoCreateContainerGaps(true);
		/*Parece que aqui criamos um eixo vertical e um horizontal, para cada eixo horizontal, uma linha de componentes é chamada
		 * e uma coluna de componenmtes também é chamada de forma paralela, mas como temos apenas um botão, fica mais simples.
		 * o addComponent(arg passa o componente botão como parâmetro, este deve ser adicionado nas duas dimensões)*/
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
