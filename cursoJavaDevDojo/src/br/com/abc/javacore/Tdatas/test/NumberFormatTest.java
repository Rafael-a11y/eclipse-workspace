package br.com.abc.javacore.Tdatas.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class NumberFormatTest {

	public static void main(String[] args) {
		
		float valor = 212.4567F;
		//Criando um Locale que tem de parâmetro uma String linguagem;
		Locale locItalia = new Locale("IT");
		//Array de NumberFormat,.
		NumberFormat[] nfa = new NumberFormat[4];
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getInstance(locItalia);
		nfa[2] = NumberFormat.getCurrencyInstance();
		nfa[3] = NumberFormat.getCurrencyInstance(locItalia);
		
		for(NumberFormat nf : nfa) {
			nf.setMaximumFractionDigits(4);
			System.out.println(nf.format(valor));
		}
		
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(nf.getMaximumFractionDigits());
		nf.setMaximumFractionDigits(4);
		System.out.println(nf.getMaximumFractionDigits());
		String valorString = "2124567,34";
		try {
			System.out.println(nf.parse(valorString));
			nf.setParseIntegerOnly(true);
			System.out.println(nf.parse(valorString));
			//Cria um NumberFormat com o Locale especificado, se for o EUA, a casa decimal é representada por .
			NumberFormat test = NumberFormat.getInstance(new Locale("US"));
			//Define o número de dígitos mostrados após a casa decimal
			test.setMaximumFractionDigits(1);
			//Retorna em String o valor formatado
			System.out.println(test.format(123.456F));
			NumberFormat test2 = NumberFormat.getInstance();
			//Usando o getInstance() Padrão, será gerado o NumberFormat de acordo com a localização atual da JVM.
			System.out.println(test2.format(123.45));
			//Retorna uma moeda, caso o getCurrencyInstance tenha como parâmetro um Locale, esta moeda será criada de acordo
			//com o Locale fornecido
			NumberFormat test3 = NumberFormat.getCurrencyInstance(new Locale("IT"));
			System.out.println(test3.format(123));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
