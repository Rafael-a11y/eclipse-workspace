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
		//No m�todo forEach() o que acontece � que ao criare um objeto Consumer, este objeto ter� acesso ao m�todo abstrato
		//aceept(), o que acontecer� � o polimofirsmo, pois o accept() que ser� executado � a fun��o lambda, que substitui
		//o trabalho de criar uma classe an�nima e sobrescrever o m�todo, a fun��o lambda � o pr�prio m�todo sobrescrito
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
		//Lembrando que essas interfaces usam generics, ent�o, caso voc� queira criar uma classe e um objeto an�nimo para sobrescrever
		//o m�todo, lembre-se de na hora de instanciar o objeto an�nimo, usar o generics para especificar os tipos de valores que
		//ser�o processados
		List<Integer> list = map(asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> s.length());
		System.out.println(list);
		List<Carro> carros = asList(new Carro("preto", 2011), new Carro("preto", 2011), new Carro("preto", 2011));
		List<String> listCores = map(carros, (Carro c) -> c.getCor());
		System.out.println(listCores);
		Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
		System.out.println(pares.test(1000));
//		Interface funcional que trabalha com tipo primitivo int e n�o com wrapper, pois fazer boxing consome processamento
//		desnecess�rio, claro que isso n�o � um problema, mas caso voc� queira trabalhar em um sistema que precisa ter alta
//		performance, use as interfaces funcionais que trabalham com tipos primitivos
		IntPredicate par = (int i) -> i % 2 == 0;
		IntPredicate impar = (int i) -> i % 2 == 1;
		System.out.println(impar.test(9999));
		System.out.println(impar.and(par).and(impar).test(1));
//		Mesmo taarget type, por isso a lambda usada pode ser exatamente a mesma, pois o contexto � o mesmo, o
		Callable<Integer> c = () -> 100 * 2;
		PrivilegedAction<Integer> p = () -> 100 * 2;
		System.out.println(c.call());
		System.out.println(p.run());
		String cor = "VERMELHO";
//		Quando n�o se declara o tipo, n�o precisa de par�ntesis, por�m, dependendo da situa��o, � bom declarar o tipo da vari�vel,
//		pois dependendo do c�digo, pode causar confus�o e ficar dif�cil de ler para outro programador, exemplo: na linha em que 
//		a lista ListCores � criada, o tipo declarado � String, mas na lambda trabalhamos com Carro, neste caso, � bom deixar claro
//		que estamos trabalhando com um Carro (declarando na lambda), pois a primeira vista, parece que estamos trabalhando com uma
//		String.
		Predicate<String> pp = s -> listCores.add(s);
		//Statement expression, uma lambda void consegue retornar processar uma fun��o que retorna boolean, desde que voc� n�o
		//tente retornar nada, na lambda b, usei a variavel cor como insumo, mesmo que ela tenha sido declarado antes da lambda,
		//pode ser usada na lambda, isso porque � uma vari�vel efetivamente final, ou seja, que mesmo que n�o seja final, seu valor
		//n�o � alterado durante o algor�timo, agora se tentarmos alterar po valor de cor, mesmo depois da linha em que a lambda �
		//executada (inserir o valor de cor na lista de cores), h� um erro de compila��o. Agora, se a variavel for de inst�ncia
//		ou de classe, est�tica, n�o h� problemaas algum, pois essas s�o compartilhadas entre as threads, j� vari�veis locais s�o
//		copiadas de uma thread � outra.
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
	//<T> tipo de valor que ser� trabalhado no m�todo, List<T> significa que a lista pode ser de qulquer tipo, e o consumer
	//signica uma lambda que recebe algo e n�o retorna nada, o accept() serve para executar a lambda
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
