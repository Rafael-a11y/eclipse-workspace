package swing;

import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MnemonicEx extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MnemonicEx() {
		initUI();
	}
	
	public void initUI() {
		var btn = new JButton("Botão");
		btn.addActionListener(event -> System.out.println("Botão pressionado"));
		btn.setToolTipText("Ativa um mnemonic");
		btn.setMnemonic(KeyEvent.VK_B);
		
		createLayout(btn);
	}
	
	public void createLayout(JComponent arg) {
		var pane = this.getContentPane();
		var gl = new GroupLayout(pane);
		pane.setLayout(gl);
		
	}
}
