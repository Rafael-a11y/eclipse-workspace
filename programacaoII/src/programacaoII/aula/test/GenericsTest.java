package programacaoII.aula.test;

interface Pair<K, V>{
	K getKey();
	V getValue();
}
//Se a interface é genérica, a classe implementadora deve ser também, e os tipos devem ser redeclarados. Não sou obrigado a
//escrever o nome da interface junto dos parâmetros (Pair<K,V>), mas o compilador fica dando mensagem de alerta.
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
//T é o parâmetro de tipo, e nãoo o argumento de tipo
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
//		generico(new Turma("Metodologias ágeis", "CCT0068"));
//		System.out.println(genericoQueRetorna(10));
		//Integer é o argumento de tipo, o dado Integer é o argumento de tipo, enquanto T é o parâmetro.	
		Box<Integer> box = new Box<>();
		int num = 89;
		box.set(num);
		System.out.println(box.get());
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		Pair<String, String> p2 = new OrderedPair<String, String>("Hello", "Word");
		//Você também pode substituir o parâmetro de tipo por um tipo parametrizado, como o Box<>, exemplo:
		Pair<String, Box<Integer>> p3 = new OrderedPair<String, Box<Integer>>("Olá", new Box<Integer>());
		//Você também pode neste mesmo cenário usar a notação diamante.
		Pair<String, Box<String>> p4 = new OrderedPair<>("Oi", new Box<>());
		System.out.println(p4.getKey());
		p4.getValue().set("Galerinha do mal");
		System.out.println(p4.getValue().get());
		Box b1 = new Box();
		//Tipo bruto é a omição de tipo de argumento de uma interface ou classe genérica, o código abaixo é um exemplo de
		//tipo bruto, criei um objeto de um tipo genérico, mas não especifiquei o tipo
		b1.set(9);
		System.out.println(b1.get());
		//Por questão de compatibilidade com versões anteriores, você pode atribuir um tipo bruto ao tipo parametrizado,
		// exemplo : Box b1 = new Box(); Box box<Integer> = b1; Mas o caso contrário adia a captura de código inseguro,
		//além de um aviso de conversão não checada -> box = b1;
		b1 = box;
	}
	//Usando generics, você precisa declarar todos os tipos que serãao usados ou podem ser usados, mesmo que você não use,
	//como uma variável que é declarada e não é usada, mas é obrigatório sim declarar os tipos, e isso deve ser feito antes
	//da palavra reservada de retorno.
	public static<T> void generico(T generico) {
		System.out.println(generico);
	}
	//Aparentemente não é possível fazer cast, nem dar valores para o tipo generico, não é possível declarar a variável de tipo
	//genérico, pois a ideia é trabalhar com um dado que já exista, mas você pode imprimi-lo, fazer comparações, retorna-lo
	public static <R> boolean genericoQueRetorna(R r) {
		return r.equals(10);
	}
}
