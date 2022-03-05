package br.com.abc.javacore.Uexpressoesregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegularesTest {

	public static void main(String[] args) {
		// \d Encontra todos os d�gitos
		// \D Encontra tudo o que n�o � d�gito
		// \s Encontra espa�os em branco -> \t \n \f \r
		// \S Caracter que n�o � branco
		// \w Caracter de palavras -> a-z, A-Z, d�gitos e _ 
		// \W Encontra tudo o que n�o for caracter de palavra
		// [] Encontra os simbolos especificados
		// ?  Pode aparecer 0 ou uma vez
		// *  Pode aparecer 0 ou mais vezes
		// +  Pode aparecer uma ou mais vezes
		// {n,m} de n at� m
		// () serve para agrupar uma express�o
		// | serve para usar ou
		// $ serve para encontrar algo que esteja no fim da linha
		// o(v|c)o = ovo, oco
		// maca(rr|c)�o = macarr�o, macacac�o
		// . coringa -> 1.3 = 123, 133, 1A3, 1#3, 1 3 -> Usa-se \\. para especificar que o ponto � um texto e n�o um comando
		// ^ serve de nega��o para a express�o regular -> [^abc] = desconsiderar tais s�mbolos.
		int hex = 0x1;
		int numeroHex = 0xaFF;
		int numeroHex2 = 0xFFABC;
		int numeroHex3 = 0xa;
		Integer numeroDec = 256;
//		String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//		String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
//		String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
//		String texto = "fulano@hotmail.com, 102Abc@gmail.com, #@!abrao@mail.br, teste@gmail.com.br, teste@mail";
//		String regex = "\\d{2}/\\d{2}/\\d{2,4}";
//		String texto = "05/10/2010 05/05/2015 01/01/01 05/01/95"; // dd/mm/aaaa
		String regex = "proj([^,])*";
		String texto = "proj1.bkp, proj1.java, proj1.class, proj1final.java, proj2.bkp, proj3.java, diagrama, texto, foto";
		System.out.println("Ocorr�ncia v�lida: " + "proj1.bkp,".matches(regex));
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("texto:    " + texto);
		System.out.println("�ndice:   0123456789");
		System.out.println("Express�o: " + matcher.pattern());
		System.out.println("Posi��es encontradas: ");
		while(matcher.find()) {
			System.out.println("�ndice " + matcher.start() + ": " + matcher.group());
		}
		System.out.println(numeroHex);
		System.out.println(numeroHex2);
		System.out.println("O n�mero decimal " + numeroDec + ", convertido para hexaDecimal"
				+ " � representado por: " + Integer.toHexString(numeroDec));
	} 
}
