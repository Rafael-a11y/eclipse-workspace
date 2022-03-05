package swing.gerenciadores;
/*O diferencial do FlowLayout é qque ele respeita o tamanho dos componentes e os adiciona em linha reta, caso não dê para
 * adicionar mais componentes, o gerenciador de layout FlowLayout se encarrega de inseri-los na linha seguinte, este 
 * gerenciador é padrão do JPanel.*/
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
//Um painél que tem como membro um gerenciador de layout que será definido
//no métpdo initialize().
public class FlowLayoutPanel extends JPanel{
	
	//gerenciador de layout FlowLayout que adiciona em linha os componentes, além de
		//respeitar o tamanho dos componentes.
		FlowLayout layout;
		
	private class AlignmentAction extends AbstractAction{
		//Vai servir para decidir o alinhamento do componente botão
		private int alignment;
		public AlignmentAction(String name, int align) {
			super(name);
			this.alignment = align;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//Especifica a forma de alinhamento chamando o método da classe externa JPanel.
			layout.setAlignment(alignment);
			//chama o método da classe externa JPanel.
			revalidate();
		}
	}
	
	private class OrientationAction extends AbstractAction{
		
		private ComponentOrientation orientation;
		
		public OrientationAction(String name, ComponentOrientation o) {
			super(name);
			orientation = o;
		}
		
		public void actionPerformed(ActionEvent e) {
			//Especifica a orientação chamando o método da classe externa JPanel.
			setComponentOrientation(orientation);
			//Chama o método da classe externa JPanel.
			revalidate();
		}
	}
	
	public FlowLayoutPanel() {
		this.initialize();
	}
	
	public void initialize() {
		this.setPreferredSize(new Dimension(500, 70));
		//Definindo no construtor os vãos e o alinhamento.
		layout = new FlowLayout(FlowLayout.CENTER, 20, 20);
		//Definindo o gerenciador de layout que irá organizar este painél.
		this.setLayout(layout);
		//O nome do Objeto de Aalinhamento é o nome do botão nestre caso.
		//Internamente, oconstrutor de AlgnmentAction que é um Action recebe o valor passado no construtor  e usa este
		//valor para chamar o método setAlignment do FlowLayout
		this.add(new JButton(new AlignmentAction("left", FlowLayout.LEFT)));
		this.add(new JButton(new AlignmentAction("Center", FlowLayout.CENTER)));
		this.add(new JButton(new AlignmentAction("Right", FlowLayout.RIGHT)));
		this.add(new JButton(new AlignmentAction("Leading", FlowLayout.LEADING)));
		this.add(new JButton(new AlignmentAction("Trailing", FlowLayout.TRAILING)));
		this.add(new JButton(new OrientationAction("Left to Right", ComponentOrientation.LEFT_TO_RIGHT)));
		this.add(new JButton(new OrientationAction("Right to left", ComponentOrientation.RIGHT_TO_LEFT)));
		
	}	
}
