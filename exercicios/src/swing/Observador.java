package swing;
/*Quando se trata de uma Interface Funcional (não precisa usar @FunctionalInterface, assim 
 * como não precisa usar @Override para sobrescrever um método), nós podemos:
 * 1 - Usar um objeto que implementa a Interface Funcional ActionListener, e sobrescrever o
 * método actionPeerformed(ActionEvent e);
 * 2 - Podemos usar uma classe anônima e já sobrescrever o método actionPerformed(ActionEvent e);
 * 3 - Ou podemos usar uma lambda que serve justamente para substituir a classe anônima para
 * deixar o código menos verboso e mais limpo.
 * Obs: Um evento em um botão pode estar associado a mais de um observador.
 * 		Uma classe anônima pode ser usada sem nescessariamente implementar uma interface, mas
 * 		o memso não pode ser usado para lambdas, é preciso usar uma interface funcional para
 * 		usar uma lambda parar implementar o método*/
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
		//Ocupa a tela inteira se não especificar a posição
//		janela.add(botao);
		//Serve para o botão não ocupar a tela innteira.
		janela.setLayout(new FlowLayout());
		//Serve para centralizar a janela em relação a janela de trás, como essa é a única 
		//janela que estamos gerando, usamos o parâmetro null para dizer que queremos que a 
		//janela seja cenntralizada em relação a tela do computador.
		janela.setLocationRelativeTo(null);
		janela.add(botao);
		janela.add(new JComboBox<>());
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um evento com classe anônima", "EVENTO", JOptionPane.INFORMATION_MESSAGE);				
			}
		});
		botao.addActionListener(e -> {System.out.println("Evento ocorreu com lambda");});
		
	}
	
}
