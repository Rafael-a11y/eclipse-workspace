package fundamentos;

public class RevisaoNotacaoPonto {
	
	public static void main(String[] args) {
		
		String y = "Bom dia RAFAEL SOUTO DA SILVA";
		System.out.println(y.charAt(2));
		System.out.println(y.charAt(3));//Mostra a letra equivalente ao n�mero.
		System.out.println(y.contentEquals("Bom dia RAFAEL"
				+ " SOUTO DA SILVA"));	//Compara as Strings e diz se � 
										//verdadeiro ou falso
		
		System.out.println(y.equalsIgnoreCase("bom dia rafael "
				+ "souto da silva"));	//Tamb�m compara as Strings e diz se o
										//valor � verdadeiro ou falso, com a 
										//diferen�a que a Caixa � ignorada.
		
		System.out.println(y.contains
				("Bom"));				//Verifica se a String "Bom", se encontra 
										//na vari�vel
		
		System.out.println(y.indexOf
				("dia"));				//Mostra a partir de qual posi��o come�a a
										//palavra presente na String.
		
		System.out.println(y.substring
				(4));					//Serve para a partir do n�mero, a String
										//ser mostrada a partir de certa posi��o
		
		System.out.println(y.substring
				(4, 7)); 				//Tamb�m mostra a String a partir do n�mero
										//inserido, por�m neste caso, tamb�m � in-
										//formada a posi��o final, sendo esta exclusiva
		
	
		
		
		
		
	}

}
