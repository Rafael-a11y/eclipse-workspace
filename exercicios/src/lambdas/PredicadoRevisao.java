package lambdas;

import java.util.function.Function;

public class PredicadoRevisao {
	public static void main(String[] args) {
		
		Produto produto = new Produto("PlayStaion5", 5000,0.20);
		
		Function<Produto,Boolean> isCaro = p -> {return  (1 - p.desconto)
				* p.preco >= 3000;};
				
		Function<Boolean,String> conversao = p -> {
			String resultado = "";
			resultado = p.toString();
			 if(p == true) {
				 
				 return resultado = "O produto é caro.";
			}
			else if(p == false) {
				return resultado = "O produto é barato.";
			}
			 return resultado;
		};
				System.out.println(isCaro.andThen(conversao).apply(produto));
	}

}
