package programacaoII.aula.test;
/*Esta aplica??o d? ao usu?rio a op??o de imprimir as listas,
 * adicionar uma nova fruta junto de sua quantidade, caso o 
 * usu?rio forne?a uma fruta que j? exisat na lista, apenas
 * a quantidade ? aceita e somada com a quantidade existente
 * daquela fruta, o c?digo reage bem a exce??es*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fruta{
	private String nome;
	private int quantidade;
	Fruta(){}
	Fruta(String nome, int quantidade)
	{
		this.nome = nome;this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "Fruta {nome = " + nome + ", quantidade = " + quantidade + " }";
	}
	String getNome() {
		return nome;
	}
	int getQuantidade() {
		return quantidade;
	}
	void setNome(String nome) {
		this.nome = nome;
	}
	void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
public class HortFrut {
	private static List<Fruta> frutas1 = new ArrayList<Fruta>();
	private static void listarFrutas() {
		frutas1.stream().forEach(System.out::println);
	}
	private static List<Fruta> getFrutas(){
		return frutas1;
	}
	private static Fruta criarFruta() {
		Scanner entrada = new Scanner(System.in);
		String nome = "";
		int quantidade = 0;
		System.out.println("Entre com o nome da fruta: ");
		nome = entrada.nextLine();
		System.out.println("Agora entre com o nome a quantidade: ");
		quantidade = entrada.nextInt();
//		entrada.close();
		return new Fruta(nome, quantidade);
	}
	private static void addFruta() {
		Fruta frutap = criarFruta();
		if(frutas1.stream().anyMatch(e -> e.getNome().equals(frutap.getNome()))) {
			int count = frutap.getQuantidade();
			frutas1.stream().filter(e -> e.getNome().equals(frutap.getNome())).forEach(e -> e.setQuantidade(e.getQuantidade() + count));
		}
		else {
			frutas1.add(frutap);
		}
		
	}
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		boolean continueLoop = true;
		List<Fruta> frutas = new ArrayList<Fruta>();
		
		iteracao : do {
			try {
				System.out.print("\n1 - Para adicionar uma nova fruta junto de sua quantidade\n"
						+ "2 - Para somente listar as frutas\n3 - Sair\nClique aqui: ");
				opcao = entrada.nextInt();
				switch(opcao) {
				case 1 : addFruta(); break;
				case 2 : System.out.println();getFrutas().stream().forEach(System.out::println);break;
				default : System.out.println("Saindo"); break iteracao;
				}
			}
			catch(Exception e) {
				System.out.println("\nAconteceu algo de errado\n");
			}
		}while(continueLoop);
	}
	
}
