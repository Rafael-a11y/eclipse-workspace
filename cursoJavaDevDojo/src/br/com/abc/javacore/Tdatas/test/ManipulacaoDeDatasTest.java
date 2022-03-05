package br.com.abc.javacore.Tdatas.test;

import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDatasTest {

	public ManipulacaoDeDatasTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Date date = new Date();
		//Adiciona uma hora em milissegundos para este objeto Date date, usando o m�todo set(date.get() + 3_600_000L).
		date.setTime(date.getTime() + 3_600_000L);
		System.out.println(date);
		
		//Retorna um Calendar.
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		//Verifica se domingo � o primeiro dia da semana
		if(Calendar.SUNDAY == c.getFirstDayOfWeek()) {
			System.out.println("Domingo � o 1� dia da semana.");
		}
		else {
			System.out.println(Calendar.MONDAY + " n�o � o primeiro dia da semana.");
		}
		//Verificando se hoje � quinta-feira.
		if(c.get(Calendar.DAY_OF_WEEK )== Calendar.THURSDAY) 
			System.out.println("Hoje � quinta feira"); 
		System.out.println();
		Date date3 = new Date(System.currentTimeMillis());
		System.out.println("Dia do m�s: " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Dia da semana: " + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("Dia do ano: " + c.get(Calendar.DAY_OF_YEAR));
		c.roll(Calendar.HOUR, 24);
//		c.add(Calendar.MONTH, 9);
		Date date2 = c.getTime();
		System.out.println("\n" + date2);
		//Se criar apenas um Date, ele retorna a data em ingl�s. Temos o m�todo before(Date when) que verifica se a data em quest�o
		// � antes da data when (quando), retorna true caso verdadeiro, falso caso contr�rio.
//		System.out.println(new Date());
		//retorna um Date
		System.out.println(Calendar.getInstance().getTime());
		
	}

}
