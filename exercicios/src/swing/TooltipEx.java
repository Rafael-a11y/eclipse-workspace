package swing;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
/*JFrame extends Frame que extends Window que extends Container que extends Component*/
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TooltipEx extends JFrame{

	/**
	 * 	JFrame extends Frame, Frame extends Window, Window extends Container, 
	 *Container extends Component
	 */
	private static final long serialVersionUID = 1L;
	public TooltipEx() {
		initUI();
	}
	
	public void initUI() {
	
		var btn = new JButton("Bot?o");
		btn.setToolTipText("Uma Compnente de Bot?o :)");
		//M?todo que eu defini!
		this.createLayout(btn);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createLayout(JComponent arg) {
		//Como o m?todo setToolTipText() ? da classe JPanel, usamos o cast para converter para
		//JLabel, pois este ? um tipo mais espec?fico de Container
		//JPanel extends JComponent que extends Container.
		//GroupLayout ? um gerenciador de layouts  que mprecisa ser instanciado com o componente
		//de par?metro e este panel precisa defini-lo como seu gerenciador de painel. O set
		//AutoCreatContainerGaps(boolean) serve para criar v?os na borda, caso contr?rio o bot?o aparce
		//colado na borda. O m?todo dfe inst?cia setHorizontalGroup() ou setVerticalGroup servem para
		//criar uma sequ?ncia de comoponentes e tamb?m para fornecer as coordenadas, at? o dado
		//momento, n?o achei uma forma de por um bot?o em baixo do outro, estes dois m?todos esperam
		//um Group de entrada, por isso usamos createSequentialGroup, que ? um tipo espec?fico de 
		//Group e o usamos de entrada, o addComponent() serve para adicionar um coimponente a este 
		//grupo de componentes e retorna este mesmo Group com o componente j? adicionado, o
		//addGap(int size) servepara criar v?o tanto na horizontal quanto na vertical do component.
		JButton botao2 = new JButton("Segundo bot?o");
		botao2.addActionListener((event)-> {JOptionPane.showMessageDialog(null, "Voc? apertou o segundo bot?o");});
		//Define otexto de dica do bot?o
		botao2.setToolTipText("Tamb?m n?o faz nada lek");
		//Os bot?es s?o colocados em um pain?l, e s?o organizados dentro deste apin?l por 
		//componentes invis?veis chamados de gerenciadores de layout, criamos um gerenciador
		//de layout que recebe de par?metro este pain?l, ou seja, este gerenciador ir? 
		//organizar os componentes deste pain?l
		var pane = (JPanel) this.getContentPane();
		var pane2 = (JPanel) this.getContentPane();
		var gl = new GroupLayout(pane);
		//Precisamos definir o gerenciador de layouts do pain?l com setLayout( LayoutManager mg)
		//para que o gerenciador de layout possa manipular e organizar o bot?o dentro de um pain?l,
		//caso congtr?rio, o bot?o se amplia e ocupa a tela inteira.
		pane.setLayout(gl);		
//		pane.setToolTipText("huehuehue br");
		
		
		gl.setAutoCreateContainerGaps(true);
//		var btn = new JButton("Clique aqui");
//		btn.setToolTipText("Ele n?o faz nada");
//		pane.add(btn);
		//SequentialGroup extends Group, createSequentialGroup(), addComponent(), addGap() retorna
		///Este mesmo SequentialGroup mas com o componente adicionado	
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(botao2).addGap(50).addComponent(arg));
		
		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(botao2).addComponent(arg));
		
		this.pack();
		
		
	}
	public static void main(String[] args) {
		//Cria uma fila de eventos, p?e o aap na fila de eventoss para garantir que este seja executado,
		//serve para que todos os eventos sejam executados em simultaneadade, provavelmente
		//serve paa n?o ocorrer problemas com fluxos de execu??o alternativos. Repare que ao
		//inv?s de ei iniciar o GUI com um new, envolvi ela com o m?todo invokeLater()
		EventQueue.invokeLater(() -> {
			var ex = new TooltipEx();
			ex.setVisible(true);
		});
	}
}
