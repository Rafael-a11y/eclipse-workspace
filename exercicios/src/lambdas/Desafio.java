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
		
		
		/*importe java.text.DecimalFormat, a forma de implementa��o � -> Criar uma vari�vel
		 * String que a partir dela, iremos fazer a formata��o, use # para representar os
		 * n�meros que voc� deseja que apare�am (caso o algarismo n�o exista, este n�o apare
		 * ce depois de formatado), as , servem para separar as casas do milhar, enquanto o
		 * . serve para separar as casas decimais */
		//String teste = "###,###.##";
		/*Crie o objeto DecimalFormat e use como par�metro a vari�vel que voc� criou
		 * para representar a formata��o do n�mero */
		//DecimalFormat testeF = new DecimalFormat(teste);
		/*Depois, dentro do m�todo print, aplique o m�todo format(n�mero a ser formatado)
		 * em cima do objeto DecimalFormat*/
		//System.out.println(testeF.format(3235.8923));
				
		
		
		
	}
}
