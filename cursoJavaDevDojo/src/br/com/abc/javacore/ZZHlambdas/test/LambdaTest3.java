package br.com.abc.javacore.ZZHlambdas.test;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import br.com.abc.javacore.ZZHlambdas.classes.Carro;
import br.com.abc.javacore.ZZHlambdas.classes.ComparadorCarro;

public class LambdaTest3 {
//	Para usar Method Reference, a lambda precisa ser simples, isso é: que chama apenas um método, e na hora de usar o Method Reference,
//	você precisa também apagar as setas e o parêntesis com parâmetro (se houver, claro), ao invés da lâmbda, apenas faça o
//	Method Reference, o Java já saberá o que é para ser processado.
	public static void main(String[] args) {
		forEach(asList("William", "DevDojo", "facebook.com/devdojobr"), System.out::println);
		List<Carro> carros = asList(new Carro("Vermelho", 1999), new Carro("Azul", 2005), new Carro("Preto", 1985));
//		Collections.sort(carros, new Comparator<Carro>() {
//			public int compare(Carro o1, Carro o2) {
//					return o1.getCor().compareTo(o2.getCor());
//			}
//		});
//		O que define um Comparator é o método compareTo(), não dá para usar Method Reference na linha abaixo, pois não é uma
//		lambda simples, sem contar que o compareTo precisa de mais de um parâmetro, no caso abaixo, você não precisa chamar o
//		compare() pois o método sort() já se encarrega disso, pois a lambda que você escreveu serve apenas de parâmetro.
//		Referência a um método estático
		Collections.sort(carros,  ComparadorCarro::comparePorCor);
//		Referência á um construtor, a interface é Supplier pois esta não recebe nada e devolve alguma coisa.
		Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new;
//		Referência a um método de instância, usa-se o get() para poder recuperar o objeto.
		Collections.sort(carros, comparadorCarroSupplier.get()::comparePorAno);
		System.out.println(carros);
		List<String> nomes = asList("William", "DevDojo", "Anna", "Brenon");
		nomes.sort((s1, s2) -> s1.compareTo(s2));
//		Referência a um método de instância a partir de sua classe.
		nomes.sort((String::compareTo));
		System.out.println(nomes);
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger2 = Integer::parseInt;
//		BiPredicate<List<String>, String> contains = (lista, elementos) -> lista.contains(elementos);
		BiPredicate<List<String>, String> contains2 = List::contains;
		System.out.println(stringToInteger.apply("10"));
		System.out.println(contains2.test(nomes, "William"));
		System.out.println(comparadorCarroSupplier.get());
//		BiFunction<String, Integer, Carro> carroBiFunction = (s, i) -> new Carro(s, i);
//		Method Reference para um construtor
		BiFunction<String, Integer, Carro> carroBiFunction = Carro::new;
		System.out.println(carroBiFunction.apply("rosa" ,1999));
		Function<String, Integer> stringParaInteger = Integer::parseInt;
		System.out.println(stringParaInteger.apply("4"));
		Function<Carro, String> getCorCarro = Carro::getCor;
		System.out.println(getCorCarro.apply(new Carro("Azul Marinho", 2021)));
		BiFunction<String, Integer, Carro> methodCarro = (s, i) -> new Carro(s, i);
		System.out.println(methodCarro.apply("Branco", 2020));
//		Mesmo que eu não passe os parâmetros, o Java entende que eu me refiro ao construtor que pede uma cor e um ano para
//		criar o carro, Carro::new, logo, quanddo chamo a apply(), ele já pede os parâmetros
		BiFunction<String, Integer, Carro> methodCarro2 = Carro::new;
		System.out.println(methodCarro2.apply("Amarelo", 2019));
//		A princípio, dava erro de compilação, mas ao definir um construtor padrão na classe Carro, o MethodReference funcionou
//		muito bem com o Supplier Carro::new; Já com o BiFunction funcionou de primeira pois os argumentos batem exatamente com
//		o construtor que pede um String, um Integer e obviamente retorna um Carro. Agora repare as linhas abaixo, criei uma
//		lambda Supplier que faz referência a um construtor padrão, e logo depois defino a cor e ano do objeto, depois crio uma
//		lambda BiFunction que também faz referência a um construtor, e na hora de usar o apply(), uso a variavel methodCarro3
//		como parâmetro.
		Supplier<Carro> methodCarro3 = Carro::new;
		methodCarro3.get().setCor("Bege");
		methodCarro3.get().setAno(2020);
		BiFunction<String, Integer, Carro> methodCarro3Continuacao = Carro::new;
		methodCarro3Continuacao.apply(methodCarro3.get().getCor(), methodCarro3.get().getAno());
		
		
		 
		}
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T e: list) {
			c.accept(e);
		}
	}
	public static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> result = new ArrayList<>();
		for(T e : list) {
			result.add(f.apply(e));
		}
		return result;
	}
}
