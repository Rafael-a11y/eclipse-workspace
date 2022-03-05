package swing;
/*Quando se trata de uma Interface Funcional (n�o precisa usar @FunctionalInterface, assim 
 * como n�o precisa usar @Override para sobrescrever um m�todo), n�s podemos:
 * 1 - Usar um objeto que implementa a Interface Funcional ActionListener, e sobrescrever o
 * m�todo actionPeerformed(ActionEvent e);
 * 2 - Podemos usar uma classe an�nima e j� sobrescrever o m�todo actionPerformed(ActionEvent e);
 * 3 - Ou podemos usar uma lambda que serve justamente para substituir a classe an�nima para
 * deixar o c�digo menos verboso e mais limpo.
 * Obs: Um evento em um bot�o pode estar associado a mais de um observador.
 * 		Uma classe an�nima pode ser usada sem nescessariamente implementar uma interface, mas
 * 		o memso n�o pode ser usado para lambdas, � preciso usar uma interface funcional para
 * 		usar uma lambda parar implementar o m�todo*/
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class EventoAconteceu implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Evento Ocorreu com class interna");
		JOptionPane.showMessageDialog(null, "Ocorreu um evento", "EVENTO", JOptionPane.PLAIN_MESSAGE);
	}
}

public class Observador {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Observador");
		janela.setSize(1000, 700);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton botao = new JButton("Clicar");
		//Ocupa a tela inteira se n�o especificar a posi��o
//		janela.add(botao);
		//Serve para o bot�o n�o ocupar a tela innteira.
		janela.setLayout(new FlowLayout());
		//Serve para centralizar a janela em rela��o a janela de tr�s, como essa � a �nica 
		//janela que estamos gerando, usamos o par�metro null para dizer que queremos que a 
		//janela seja cenntralizada em rela��o a tela do computador.
		janela.setLocationRelativeTo(null);
		janela.add(botao);
		janela.add(new JComboBox<>());
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um evento com classe an�nima", "EVENTO", JOptionPane.INFORMATION_MESSAGE);				
			}
		});
		botao.addActionListener(e -> {System.out.println("Evento ocorreu com lambda");});
		
	}
	
}
