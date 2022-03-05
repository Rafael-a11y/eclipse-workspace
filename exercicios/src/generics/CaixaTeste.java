package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaixaTeste {
	public static void main(String[] args) {
		
		//Se eu não especificar o tipó, por padrão será criado um Object, ou seja, fica irredundante usar
		//generics na classe e na hora de instanciar não especificar o tipo
//		Caixa caixaC = new Caixa();
//		caixaC.guardar("arroz");
//		String coisa = (String) caixaC.abrir();
//		System.out.println(coisa);
//		
//		System.out.println();
//		
//		Caixa<String> caixaA = new Caixa<>();
//		caixaA.guardar("segredo");
//		String coisaA = caixaA.abrir();
//		System.out.println(coisaA);
//		
//		Caixa<Double> caixaB = new Caixa<>();
//		caixaB.guardar(3.1415);
//		Double coisaB = caixaB.abrir();
//		System.out.println(coisaB);
		List<Double> numeros = new ArrayList<>();
		numeros.add(10.00);
		numeros.add(8.0);
		numeros.add(5.0);
		numeros.add(4.0);
		List<Double> numerosExcluidos = numeros.stream().filter(e -> e == 8.00).collect(Collectors.toList());
		numeros.stream().forEach(System.out::println);
		numerosExcluidos = numeros.stream().collect(Collectors.toList());
	}
}
