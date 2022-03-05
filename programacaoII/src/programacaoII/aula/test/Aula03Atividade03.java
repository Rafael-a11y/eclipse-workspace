package programacaoII.aula.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aula03Atividade03 {
public static void main(String[] args) {
	List<Character> letras = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m');
	System.out.println(letras);
	//embaralhando
	Collections.shuffle(letras);
	System.out.println(letras);
	
	//Invertendo a ordem natural das letras
	Comparator<Character> comparador = Collections.reverseOrder();
	Collections.sort(letras, Collections.reverseOrder());
	System.out.println(letras);
	}
}
