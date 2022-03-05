package programacaoOOEmJava.basico;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Item{
	 String nome;
	 int preco;
	 Item(String nome, int preco) {
		this.nome = nome;
		this.preco = preco;
	}
	String getNome() {
		return this.nome;
	}
	int getPreco() {
		return this.preco;
	}
}
class Cliente{
	//Quanto o cliente possui de dinheiro depositado na conta.
	private int saldo;
	//Quanto o cliente pode gastar no momento.
	private int limiteDisponivel;
	//Limite total do cart�o.
	private final int limiteTotal;
	//Somat�ria de pre�o  de todas as compras
	private int despesas;
	//Lista de ITENS comprados.
	final List<Item> ITENS = Arrays.asList(new Item("Pizza", 30),
			new Item("X�cara", 10),
			new Item("Sof�", 2000));
	Cliente(int saldo, int limiteTotal){
		this.saldo = saldo;
		this.limiteTotal = limiteTotal;
	}
	List<Item> getItens(){
		return ITENS;
	}
	int getSaldo() {
		return saldo;
	}
	void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	int getDespesas() {
		return this.despesas;
	}
	void setDespesas(int despesas) {
		this.despesas = despesas;
	}
	int calculandoDespesas() {
		return despesas = this.ITENS.stream().collect(Collectors.summingInt(Item::getPreco));
	}
	int getLimiteDisponivel() {
		return limiteDisponivel;
	}
	void setLimiteDisponivel(int limiteDisponivel) {
		this.limiteDisponivel = limiteDisponivel;
	}
	int calculandoLimiteDisponivel() {
		return this.limiteDisponivel = this.limiteTotal - calculandoDespesas();
	}
	int getLimiteTotal() {
		return this.limiteTotal;
	}
	//Deve ser calculado no dia 10;
	void calculandoNovoLimite() { // gastei 400/600, sobra 200 de limite, depositei 300, resultar em 500 e  vai sobrar 100 de saldo
		if(getCalendar() instanceof Date) {
			System.out.println("(dentro do calculandoNovoLimite()) total da fatura:" + calculandoDespesas());
			int result = getSaldo() - calculandoDespesas();
			if(result >= 0) {
				setDespesas(0);
				setLimiteDisponivel(getLimiteTotal());
				setSaldo(result);
				System.out.println("Limite total: " + getLimiteTotal());
				System.out.println("novo limte liberado(o seu limite m�ximo deste m�s): " + getLimiteDisponivel());
				System.out.println("Saldo em conta: " + getSaldo());
				System.out.println("Despesas totais: " + getDespesas());
			}
			else if(result < 1) {
				System.out.println("Limite m�ximo n�o liberado, pois voc� n�o pagou toda a fatura: " + Math.abs(result) + "\nPara"
						+ " mais informa��es, entre em contato como o gerente do banco mais pr�ximo");
				setSaldo(0);
				System.out.println("Limite total: " + getLimiteTotal());
				System.out.println("Limite liberado: " + getLimiteDisponivel() + ", seu limite deste m�s continuar� sendo " 
						+ calculandoLimiteDisponivel());
				System.out.println("Saldo em conta: " + getSaldo());
				System.out.println("Despesas totais: " + getDespesas());
			}
		}
		else {
			System.out.println("(dentro do calculandoNovoLimite())Ainda n�o � o dia de vencimento da fatura");
		}
	}
	Date getCalendar() {
		System.out.println("(dentro do getCalendar)Verificando se estamos no dia da fatura...");
		Calendar c = Calendar.getInstance();
		if(c.get(Calendar.DAY_OF_MONTH) == 10 && c.get(Calendar.HOUR_OF_DAY) == 19) {
			System.out.println("(dentro do getCalendar)Estamos no dia da fatura");
			return c.getTime();
		}
		else {
			System.out.println("(dentro do getCalendar)N�o � dia de vencimento da fatura");
			return null;
		}
	}
}
public class Programinha {

	public static void main(String[] args) {
		int entrada;
		System.out.println("Entre com uma das op��es");
		System.out.println("1 - Para analisar 3 valores e dizer qual � o maior");
		System.out.println("2 - Verificar se o n�mero � par ou �mpar");
		System.out.println("3 - Imprimir todos os n�meros de 150 at� 300");
		System.out.println("4 - Imprimir a soma de 1 at� 1000");
		System.out.println("5 - Imprimir o custo de f�brica de um carro novo ao consumidor, sendo que tal custo �\n\tconstru�do"
				+ " a partir da soma do pre�o de f�brica + percentagem do distribu�dor + impostos\n\t(aplicados ao carro).");
		System.out.println("6 - Verifica se os clientes da loja excederam o limite do cart�o de c�dito.");
		System.out.println("7 - Finaliza o programa");
		System.out.println("Digite um op��o: ");
		Scanner scanner = new java.util.Scanner(System.in);
		entrada = scanner.nextInt();
		
		switch(entrada) {
			case 1 : analisarValores(); break;
			case 2 : parOuImpar(entrada()); break; 
			case 3 : impressaoExaustiva(); break;
			case 4 : impressaoExaustivamenteExaustiva(); break;
			case 5 : calculandoPrecoDoCarro(); break;
			case 6 : verificandoCliente();
		}
		
		scanner.close();
	}
	private static Integer entrada() {
		java.util.Scanner entrada = new java.util.Scanner(System.in);
		int numerico;
		System.out.println("Entre com o n�mero: ");
		numerico = entrada.nextInt();
		return numerico;
	}
	private static void analisarValores() {
		java.util.Scanner entrada = new java.util.Scanner(System.in);
		System.out.println("Entre com o 1� n�mero: ");
		int numero1 = entrada.nextInt();
		System.out.println("Entre com o 2� n�mero: ");
		int numero2 = entrada.nextInt();
		System.out.println("Entre com o 3� n�mero: ");
		int numero3 = entrada.nextInt();
		int[] array = {numero1,numero2,numero3};
		int maiorNumero = 0;
		for(int i = 0; i < array.length; i++) {
			if(maiorNumero < array[i]) maiorNumero = array[i];
		}
		System.out.println("O maior n�mero �: " + maiorNumero);
		
	}
	private static void parOuImpar(int numerico) {
		if(numerico % 2 == 0 ) System.out.println(numerico + " � par");
		else System.out.println(numerico + " � impar");
	}
	private static void impressaoExaustiva() {
		for(int i = 150; i <= 300; i++) System.out.println(i);
	}
	private static void impressaoExaustivamenteExaustiva() {
		int num = 1;
		while(num <= 1000) {
			System.out.println(num++);
		}
	}
	private static void calculandoPrecoDoCarro() {
		System.out.println("Entre com o valor de f�brica: ");
		float custoDeFabrica = new Scanner(System.in).nextFloat();
		float percentagem = 0.28F * custoDeFabrica;
		float imposto = 0.45F * custoDeFabrica;
		float valorFinal = (custoDeFabrica + (percentagem) + (imposto));
		System.out.printf("O pre�o final �: %.2f", valorFinal);
		
	}
	private static void verificandoCliente() {
		int saldo, limite;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com o saldo: ");
		saldo = entrada.nextInt();
		System.out.println("Agora entre com o limite m�ximo: ");
		limite = entrada.nextInt();
		Cliente cliente = new Cliente(saldo, limite);
		entrada.close();
		cliente.calculandoNovoLimite();
	}
}