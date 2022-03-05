package lambdas;

import java.text.DecimalFormat;
import java.util.function.Function;

public class Desafio {
	
	public static void main(String[] args) {
		
		String formatacao = "###,###.##";
		DecimalFormat df = new DecimalFormat(formatacao);
		
		Produto produto = new Produto("iPad", 3235.89, 0.13);
		
		Function<Produto, Double> pComDesconto = p -> {return (1 - p.desconto) * p.preco;};

		Function<Double, Double> impostoMunicipal = valor -> { if(valor >=2500) {
			 valor = valor * 1.085;}
		return valor;
		};
		
		Function<Double,Double> frete = valor -> {if(valor >= 3000) {
			valor += 100;}
		else {
			valor += 50;
		}
		return valor;
		};
		
		Function<Double,String> imprimir = num -> {return df.format(num);};
		
		System.out.println("R$" + pComDesconto.andThen(impostoMunicipal).andThen(frete)
				.andThen(imprimir).apply(produto));
		
		
		/*importe java.text.DecimalFormat, a forma de implementação é -> Criar uma variável
		 * String que a partir dela, iremos fazer a formatação, use # para representar os
		 * números que você deseja que apareçam (caso o algarismo não exista, este não apare
		 * ce depois de formatado), as , servem para separar as casas do milhar, enquanto o
		 * . serve para separar as casas decimais */
		//String teste = "###,###.##";
		/*Crie o objeto DecimalFormat e use como parâmetro a variável que você criou
		 * para representar a formatação do número */
		//DecimalFormat testeF = new DecimalFormat(teste);
		/*Depois, dentro do método print, aplique o método format(número a ser formatado)
		 * em cima do objeto DecimalFormat*/
		//System.out.println(testeF.format(3235.8923));
				
		
		
		
	}
}
