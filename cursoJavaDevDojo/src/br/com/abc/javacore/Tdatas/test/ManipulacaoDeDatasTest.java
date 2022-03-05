package br.com.abc.javacore.Tdatas.test;

import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDatasTest {

	public ManipulacaoDeDatasTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Date date = new Date();
		//Adiciona uma hora em milissegundos para este objeto Date date, usando o método set(date.get() + 3_600_000L).
		date.setTime(date.getTime() + 3_600_000L);
		System.out.println(date);
		
		//Retorna um Calendar.
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		//Verifica se domingo é o primeiro dia da semana
		if(Calendar.SUNDAY == c.getFirstDayOfWeek()) {
			System.out.println("Domingo é o 1º dia da semana.");
		}
		else {
			System.out.println(Calendar.MONDAY + " não é o primeiro dia da semana.");
		}
		//Verificando se hoje é quinta-feira.
		if(c.get(Calendar.DAY_OF_WEEK )== Calendar.THURSDAY) 
			System.out.println("Hoje é quinta feira"); 
		System.out.println();
		Date date3 = new Date(System.currentTimeMillis());
		System.out.println("Dia do mês: " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Dia da semana: " + c.get(Calendar.DAY_OF_WEEK));
		System.out.println("Dia do ano: " + c.get(Calendar.DAY_OF_YEAR));
		c.roll(Calendar.HOUR, 24);
//		c.add(Calendar.MONTH, 9);
		Date date2 = c.getTime();
		System.out.println("\n" + date2);
		//Se criar apenas um Date, ele retorna a data em inglês. Temos o método before(Date when) que verifica se a data em questão
		// é antes da data when (quando), retorna true caso verdadeiro, falso caso contrário.
//		System.out.println(new Date());
		//retorna um Date
		System.out.println(Calendar.getInstance().getTime());
		
	}

}
