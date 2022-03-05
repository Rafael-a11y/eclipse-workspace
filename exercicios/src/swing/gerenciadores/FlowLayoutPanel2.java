package swing.gerenciadores;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FlowLayoutPanel2 extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FlowLayout layout;
	
	private class AlignmentAction extends AbstractAction{

		private int alignment;
		private AlignmentAction(String name, int align) {
			super(name);
			this.alignment = align;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			layout.setAlignment(alignment);
			
			revalidate();
		}
		
	}
	
	private class OrientationAction extends AbstractAction{
		
		private ComponentOrientation orientation;
		
		private OrientationAction(String name, ComponentOrientation orientation ) {
			super(name);
			this.orientation = orientation;
		}
		
		public void actionPerformed(ActionEvent e) {
			setComponentOrientation(orientation);
			revalidate();
			
		}
	}
	
	public FlowLayoutPanel2(){
		initialize();
	}
	
	private void initialize() {
		layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEADING);
		layout.setVgap(10);
		layout.setHgap(10);
		this.setPreferredSize(new Dimension(500,70));
		this.setLayout(layout);
//		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//Creio que não dá para usar lambda porque o AlignmentAction extends final abstract AbstractionAction que implements
		//Action que extends ActionListener, ou seja, se ele implementasse diretamente Action, daria certo.
		this.add(new JButton(new AlignmentAction("Esquerda", FlowLayout.LEFT)));
		this.add(new JButton(new AlignmentAction("Centro", FlowLayout.CENTER)));
		this.add(new JButton(new AlignmentAction("Direita", FlowLayout.RIGHT)));
		this.add(new JButton(new AlignmentAction("Do Começo", FlowLayout.LEADING)));
		this.add(new JButton(new AlignmentAction("Do final", FlowLayout.TRAILING)));
		this.add(new JButton(new OrientationAction("Da Esquerda Para  Direita", ComponentOrientation.LEFT_TO_RIGHT)));
		this.add(new JButton(new OrientationAction("Da Direita para a Esquerda", ComponentOrientation.RIGHT_TO_LEFT)));
	}
}