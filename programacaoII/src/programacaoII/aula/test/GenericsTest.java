package programacaoII.aula.test;

interface Pair<K, V>{
	K getKey();
	V getValue();
}
//Se a interface � gen�rica, a classe implementadora deve ser tamb�m, e os tipos devem ser redeclarados. N�o sou obrigado a
//escrever o nome da interface junto dos par�metros (Pair<K,V>), mas o compilador fica dando mensagem de alerta.
class OrderedPair<K, V> implements Pair<K,V>{

	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
		
	}
	
	public K getKey() {return key;}

	@Override
	public V getValue() {return value;}
	
}
//T � o par�metro de tipo, e n�oo o argumento de tipo
class Box <T>{
	private T t;
	void set(T t){this.t = t;}
	T get() {return this.t;}
}
public class GenericsTest {

	public static void main(String[] args) {
//		Box<Integer> box = new Box<>();
//		int numerico = 10;
//		Integer numerico2 = 10;
//		char letra = 'A';
//		String texto = "Meu pau de asa";
//		float numero = 99.00F;
//		box.set(numerico2);
//		System.out.println(box.get());
//		generico(numerico);
//		generico(texto);
//		generico(letra);
//		generico(numero);
//		generico(new Turma("Metodologias �geis", "CCT0068"));
//		System.out.println(genericoQueRetorna(10));
		//Integer � o argumento de tipo, o dado Integer � o argumento de tipo, enquanto T � o par�metro.	
		Box<Integer> box = new Box<>();
		int num = 89;
		box.set(num);
		System.out.println(box.get());
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		Pair<String, String> p2 = new OrderedPair<String, String>("Hello", "Word");
		//Voc� tamb�m pode substituir o par�metro de tipo por um tipo parametrizado, como o Box<>, exemplo:
		Pair<String, Box<Integer>> p3 = new OrderedPair<String, Box<Integer>>("Ol�", new Box<Integer>());
		//Voc� tamb�m pode neste mesmo cen�rio usar a nota��o diamante.
		Pair<String, Box<String>> p4 = new OrderedPair<>("Oi", new Box<>());
		System.out.println(p4.getKey());
		p4.getValue().set("Galerinha do mal");
		System.out.println(p4.getValue().get());
		Box b1 = new Box();
		//Tipo bruto � a omi��o de tipo de argumento de uma interface ou classe gen�rica, o c�digo abaixo � um exemplo de
		//tipo bruto, criei um objeto de um tipo gen�rico, mas n�o especifiquei o tipo
		b1.set(9);
		System.out.println(b1.get());
		//Por quest�o de compatibilidade com vers�es anteriores, voc� pode atribuir um tipo bruto ao tipo parametrizado,
		// exemplo : Box b1 = new Box(); Box box<Integer> = b1; Mas o caso contr�rio adia a captura de c�digo inseguro,
		//al�m de um aviso de convers�o n�o checada -> box = b1;
		b1 = box;
	}
	//Usando generics, voc� precisa declarar todos os tipos que ser�ao usados ou podem ser usados, mesmo que voc� n�o use,
	//como uma vari�vel que � declarada e n�o � usada, mas � obrigat�rio sim declarar os tipos, e isso deve ser feito antes
	//da palavra reservada de retorno.
	public static<T> void generico(T generico) {
		System.out.println(generico);
	}
	//Aparentemente n�o � poss�vel fazer cast, nem dar valores para o tipo generico, n�o � poss�vel declarar a vari�vel de tipo
	//gen�rico, pois a ideia � trabalhar com um dado que j� exista, mas voc� pode imprimi-lo, fazer compara��es, retorna-lo
	public static <R> boolean genericoQueRetorna(R r) {
		return r.equals(10);
	}
}
