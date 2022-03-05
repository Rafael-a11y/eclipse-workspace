package br.com.abc.javacore.ZZHlambdas.test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;

import static java.util.Arrays.asList;

import java.security.PrivilegedAction;
import java.util.ArrayList;
public class LambdaTest2 {

	public static void main(String[] args) throws Exception {
		//No método forEach() o que acontece é que ao criare um objeto Consumer, este objeto terá acesso ao método abstrato
		//aceept(), o que acontecerá é o polimofirsmo, pois o accept() que será executado é a função lambda, que substitui
		//o trabalho de criar uma classe anônima e sobrescrever o método, a função lambda é o próprio método sobrescrito
//		forEach(asList("William", "DevDojo", "facebook.com./devdojobr"), new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		});
		forEach(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> System.out.println(s));
//		List<Integer> list = map(asList("William", "DevDojo", "facebook.com./devdojobr"),new Function<String, Integer>() {
//
//			@Override
//			public Integer apply(String t) {
//				return t.length();
//			}
//			
//		});
		//Lembrando que essas interfaces usam generics, então, caso você queira criar uma classe e um objeto anônimo para sobrescrever
		//o método, lembre-se de na hora de instanciar o objeto anônimo, usar o generics para especificar os tipos de valores que
		//serão processados
		List<Integer> list = map(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> s.length());
		System.out.println(list);
		List<Carro> carros = asList(new Carro("preto", 2011), new Carro("preto", 2011), new Carro("preto", 2011));
		List<String> listCores = map(carros, (Carro c) -> c.getCor());
		System.out.println(listCores);
		Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
		System.out.println(pares.test(1000));
//		Interface funcional que trabalha com tipo primitivo int e não com wrapper, pois fazer boxing consome processamento
//		desnecessário, claro que isso não é um problema, mas caso você queira trabalhar em um sistema que precisa ter alta
//		performance, use as interfaces funcionais que trabalham com tipos primitivos
		IntPredicate par = (int i) -> i % 2 == 0;
		IntPredicate impar = (int i) -> i % 2 == 1;
		System.out.println(impar.test(9999));
		System.out.println(impar.and(par).and(impar).test(1));
//		Mesmo taarget type, por isso a lambda usada pode ser exatamente a mesma, pois o contexto é o mesmo, o
		Callable<Integer> c = () -> 100 * 2;
		PrivilegedAction<Integer> p = () -> 100 * 2;
		System.out.println(c.call());
		System.out.println(p.run());
		String cor = "VERMELHO";
//		Quando não se declara o tipo, não precisa de parêntesis, porém, dependendo da situação, é bom declarar o tipo da variável,
//		pois dependendo do código, pode causar confusão e ficar difícil de ler para outro programador, exemplo: na linha em que 
//		a lista ListCores é criada, o tipo declarado é String, mas na lambda trabalhamos com Carro, neste caso, é bom deixar claro
//		que estamos trabalhando com um Carro (declarando na lambda), pois a primeira vista, parece que estamos trabalhando com uma
//		String.
		Predicate<String> pp = s -> listCores.add(s);
		//Statement expression, uma lambda void consegue retornar processar uma função que retorna boolean, desde que você não
		//tente retornar nada, na lambda b, usei a variavel cor como insumo, mesmo que ela tenha sido declarado antes da lambda,
		//pode ser usada na lambda, isso porque é uma variável efetivamente final, ou seja, que mesmo que não seja final, seu valor
		//não é alterado durante o algorítimo, agora se tentarmos alterar po valor de cor, mesmo depois da linha em que a lambda é
		//executada (inserir o valor de cor na lista de cores), há um erro de compilação. Agora, se a variavel for de instância
//		ou de classe, estática, não há problemaas algum, pois essas são compartilhadas entre as threads, já variáveis locais são
//		copiadas de uma thread à outra.
		Consumer<String> b = (String s) -> {listCores.add(cor);};
//		cor = "";
		pp.test("amarelo");
		b.accept("AMARELO");
		Supplier<String> sup1 = () -> "oi";
		Supplier<Carro> sup2 = () -> new Carro("Preto", 2011);
		System.out.println(sup1.get());
		System.out.println(sup2.get());
		System.out.println(listCores);
	}
	//<T> tipo de valor que será trabalhado no método, List<T> significa que a lista pode ser de qulquer tipo, e o consumer
	//signica uma lambda que recebe algo e não retorna nada, o accept() serve para executar a lambda
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T e : list) {
			c.accept(e);
		}
	}
	public static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> result = new ArrayList<R>();
		for(T e : list) {
			result.add(f.apply(e));
		}
		return result;
	}

}
