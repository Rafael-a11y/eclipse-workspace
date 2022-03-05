package br.com.abc.javacore.Tdatas.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SimpleDateFormatTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2015, 0, 25);
		String mascara = "'Recanto das Emas,' dd 'de' MMMM 'de' YYYY";
		SimpleDateFormat formatador = new SimpleDateFormat(mascara);
		System.out.println(formatador.format(c.getTime()));
		Calendar d =Calendar.getInstance();
		//Definindo a data por ano, mêss e dia, o mês começa do 0, se você tentar usar um número negativo como -1, ele dá a
		//volta nas datas em relação a data atual, no caso como é -1 no campo do mês, sabendo que 0 é janeiro e que no momento
		//desta documentação estamos em março, então o JVM deduz que queremos a adata do ano passado, de dezembro de 2020
		d.set(2021, 2, 3);
		//Usamos o SimpleDateFormat para formatar as datas em Strings, lembrando que há uma nomenclatura que pode ser achada na
		//internet, usamos uma String de parâmetro e envolvemos com aspas simples os caracteres que devem ser ignorados na formatação,
		//pois podemos usar a data junto de uma frase. 
		SimpleDateFormat sdf = new SimpleDateFormat("'Recanto das Emas ->' dd  MMMM YYYY");		
		System.out.print(d.getTime());
		System.out.println();
		System.out.println(sdf.format(d.getTime()));
//		Calendar test4 = Calendar.getInstance(new Locale("pt", "BR"));
//		System.out.println(test4.getTime());
		
	}

}
