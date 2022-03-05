package br.com.abc.javacore.Tdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		
		Date date = new Date();
		//Criando Locales forneecendo uma String linguagem e uma String país.
		Locale locItaly = new Locale("it", "IT");
		Locale locSuica = new Locale("it", "CH");
		Locale locBrasil = new Locale("pt", "BR");
		Locale locUS = new Locale("en", "US");
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 23);
		//Criando DateFormat's usando o getDateInstance sobrecarregado, dando de parâmetro, os Locales's e os tamanhos
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locItaly);
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locSuica);
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locBrasil);
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, locUS);
		//DateFormat's formatados em FULL, e em vários Locale's.
		System.out.println("DateFormat.FULL, Itália: " + df.format(c.getTime()));
		System.out.println("DateFormat.FULL, Suíça: " + df2.format(c.getTime()));
		System.out.println("DateFormat.FULL, Brasil: " + df3.format(c.getTime()));
		System.out.println("DateFormat.FULL, Estados Unidos: " + df4.format(c.getTime()));
//		System.out.println(df2.format(date));
		
		System.out.println();
		System.out.println("País de exibição do objeto Locale: " + locUS.getDisplayCountry());
		System.out.println("Linguagem de exibição do objeto Locale: " + locUS.getDisplayLanguage());
		//Vai mostrar o nome da Língua em inglês, pois temos um Locale("en","US") de parâmetro no getDisplayLanguage(locUS)
		//sobrecarregado.
		System.out.println("linguagem de exibição com o Locale locUS (Estados Unidos) de parâmetro: " 
				+ locBrasil.getDisplayLanguage(locUS));
		//Vai imprimir o nome da línguia em inglês, por conta do Locale fornecido de parâmetro, se não, seria em português,
		//pois é a localização padrão da JVM desta máquina
		System.out.println("País de exibição em inglês: " + locUS.getDisplayCountry(locUS));
		System.out.println(locSuica.getDisplayCountry(locUS));
		Locale locTeste = new Locale("pt", "BR");
		//Imprimir o objeto Locale com toString é redundante.
		System.out.println("Imprimindo locTest: " + locTeste.toString());
		Calendar test = Calendar.getInstance();
		System.out.println(test.getTimeInMillis());
		System.out.println(c.getTime());
	}

}
