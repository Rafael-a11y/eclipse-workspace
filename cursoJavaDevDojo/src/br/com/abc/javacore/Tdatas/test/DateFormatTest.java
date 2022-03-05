package br.com.abc.javacore.Tdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateFormatTest {

	public DateFormatTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		DateFormat[] dfa = new DateFormat[6];
		dfa[0] = DateFormat.getInstance();
		dfa[1] = DateFormat.getDateInstance();
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		for(DateFormat df : dfa) {
			System.out.println(df.format(c.getTime()));
		}
		System.out.println(c.getTime());
		//Vai imprimir em forma de número separado por barras a data e a hora -> / /  00:00. 
		System.out.println(DateFormat.getInstance().format(c.getTime()));
		//Vai imprimir por extenso, mas de forma bem resumidinha.
		System.out.println(DateFormat.getDateInstance().format(c.getTime()));
		//Vai imprimir de forma númerica, mas somente a data separada por data ->  / / .
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime()));
		//Formata de forma extensa, junto de uma Lovcalização em Português, onde é fornecido no new Locale(String language,
		//String country) um língua e um País, dando preferência a língua, ou seja, se fornecer a língua portuguesa e o país
		//EUA, será impressa a data no formato Brasileiro. As Strings podem ser passadas em Caps oou não, o Java consegue 
		//inferir o tipo.
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL,new Locale("PT")).format(c.getTime()));
		
	}

}
