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
		//Definindo a data por ano, m�ss e dia, o m�s come�a do 0, se voc� tentar usar um n�mero negativo como -1, ele d� a
		//volta nas datas em rela��o a data atual, no caso como � -1 no campo do m�s, sabendo que 0 � janeiro e que no momento
		//desta documenta��o estamos em mar�o, ent�o o JVM deduz que queremos a adata do ano passado, de dezembro de 2020
		d.set(2021, 2, 3);
		//Usamos o SimpleDateFormat para formatar as datas em Strings, lembrando que h� uma nomenclatura que pode ser achada na
		//internet, usamos uma String de par�metro e envolvemos com aspas simples os caracteres que devem ser ignorados na formata��o,
		//pois podemos usar a data junto de uma frase. 
		SimpleDateFormat sdf = new SimpleDateFormat("'Recanto das Emas ->' dd  MMMM YYYY");		
		System.out.print(d.getTime());
		System.out.println();
		System.out.println(sdf.format(d.getTime()));
//		Calendar test4 = Calendar.getInstance(new Locale("pt", "BR"));
//		System.out.println(test4.getTime());
		
	}

}
