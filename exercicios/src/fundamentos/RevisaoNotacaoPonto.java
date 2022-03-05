package fundamentos;

public class RevisaoNotacaoPonto {
	
	public static void main(String[] args) {
		
		String y = "Bom dia RAFAEL SOUTO DA SILVA";
		System.out.println(y.charAt(2));
		System.out.println(y.charAt(3));//Mostra a letra equivalente ao número.
		System.out.println(y.contentEquals("Bom dia RAFAEL"
				+ " SOUTO DA SILVA"));	//Compara as Strings e diz se é 
										//verdadeiro ou falso
		
		System.out.println(y.equalsIgnoreCase("bom dia rafael "
				+ "souto da silva"));	//Também compara as Strings e diz se o
										//valor é verdadeiro ou falso, com a 
										//diferença que a Caixa é ignorada.
		
		System.out.println(y.contains
				("Bom"));				//Verifica se a String "Bom", se encontra 
										//na variável
		
		System.out.println(y.indexOf
				("dia"));				//Mostra a partir de qual posição começa a
										//palavra presente na String.
		
		System.out.println(y.substring
				(4));					//Serve para a partir do número, a String
										//ser mostrada a partir de certa posição
		
		System.out.println(y.substring
				(4, 7)); 				//Também mostra a String a partir do número
										//inserido, porém neste caso, também é in-
										//formada a posição final, sendo esta exclusiva
		
	
		
		
		
		
	}

}
