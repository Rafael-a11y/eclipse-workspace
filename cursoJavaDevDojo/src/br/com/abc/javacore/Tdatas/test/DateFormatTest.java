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
		//Vai imprimir em forma de n�mero separado por barras a data e a hora -> / /  00:00. 
		System.out.println(DateFormat.getInstance().format(c.getTime()));
		//Vai imprimir por extenso, mas de forma bem resumidinha.
		System.out.println(DateFormat.getDateInstance().format(c.getTime()));
		//Vai imprimir de forma n�merica, mas somente a data separada por data ->  / / .
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime()));
		//Formata de forma extensa, junto de uma Lovcaliza��o em Portugu�s, onde � fornecido no new Locale(String language,
		//String country) um l�ngua e um Pa�s, dando prefer�ncia a l�ngua, ou seja, se fornecer a l�ngua portuguesa e o pa�s
		//EUA, ser� impressa a data no formato Brasileiro. As Strings podem ser passadas em Caps oou n�o, o Java consegue 
		//inferir o tipo.
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL,new Locale("PT")).format(c.getTime()));
		
	}

}
