package br.com.abc.javacore.Tdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		
		Date date = new Date();
		//Criando Locales forneecendo uma String linguagem e uma String pa�s.
		Locale locItaly = new Locale("it", "IT");
		Locale locSuica = new Locale("it", "CH");
		Locale locBrasil = new Locale("pt", "BR");
		Locale locUS = new Locale("en", "US");
		
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 23);
		//Criando DateFormat's usando o getDateInstance sobrecarregado, dando de par�metro, os Locales's e os tamanhos
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locItaly);
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locSuica);
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locBrasil);
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, locUS);
		//DateFormat's formatados em FULL, e em v�rios Locale's.
		System.out.println("DateFormat.FULL, It�lia: " + df.format(c.getTime()));
		System.out.println("DateFormat.FULL, Su��a: " + df2.format(c.getTime()));
		System.out.println("DateFormat.FULL, Brasil: " + df3.format(c.getTime()));
		System.out.println("DateFormat.FULL, Estados Unidos: " + df4.format(c.getTime()));
//		System.out.println(df2.format(date));
		
		System.out.println();
		System.out.println("Pa�s de exibi��o do objeto Locale: " + locUS.getDisplayCountry());
		System.out.println("Linguagem de exibi��o do objeto Locale: " + locUS.getDisplayLanguage());
		//Vai mostrar o nome da L�ngua em ingl�s, pois temos um Locale("en","US") de par�metro no getDisplayLanguage(locUS)
		//sobrecarregado.
		System.out.println("linguagem de exibi��o com o Locale locUS (Estados Unidos) de par�metro: " 
				+ locBrasil.getDisplayLanguage(locUS));
		//Vai imprimir o nome da l�nguia em ingl�s, por conta do Locale fornecido de par�metro, se n�o, seria em portugu�s,
		//pois � a localiza��o padr�o da JVM desta m�quina
		System.out.println("Pa�s de exibi��o em ingl�s: " + locUS.getDisplayCountry(locUS));
		System.out.println(locSuica.getDisplayCountry(locUS));
		Locale locTeste = new Locale("pt", "BR");
		//Imprimir o objeto Locale com toString � redundante.
		System.out.println("Imprimindo locTest: " + locTeste.toString());
		Calendar test = Calendar.getInstance();
		System.out.println(test.getTimeInMillis());
		System.out.println(c.getTime());
	}

}
