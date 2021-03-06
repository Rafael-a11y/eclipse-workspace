package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {
	public static void main(String[] args) {
		Produto produto1 = new Produto("Notebook",4000.00,0.30,0.0);
		Produto produto2 = new Produto("PlayStaion4",3000.00,0.40,0.0);
		Produto produto3 = new Produto("Chapinha",100.00,0.0,80.0);
		Produto produto4 = new Produto("Microondas",250.00,0.15,0.0);
		Produto produto5 = new Produto("Fritadeira",350.00,0.10,100.0);
		Produto produto6 = new Produto("Tv Led 40p",1200.00,0.20,0.0);
		Produto produto7 = new Produto("Iphone11",5000.00,0.40,0.0);
		
		List<Produto> produtos = Arrays.asList(produto1,produto2,
				produto3,produto4,produto5,produto6,produto7);
		
		Predicate<Produto> desconto = p -> p.desconto >= 0.31;
		Predicate<Produto> freteGratis = p -> p.frete == 0.0;
		Function<Produto, String> grandePromocao = p -> "Produto: "
				+ p.nome + ", por apenas R$" + p.preco;
		System.out.println("Grande promoc?o, lista de produtos\n"
				+ "que est?o com frete gratuito e com desconto\n"
				+ "acima de 30%!!!");
		//PipeLine de execu??o!
		produtos.stream().filter(desconto).
		filter(freteGratis).map(grandePromocao).
		forEach(System.out::println);
//		System.out.println(produto6.preco);
//		System.out.println(produto2.preco);
		//interfaces sempre usam generics para declarar os par?metros
		
	}

}
