package controle;

public class Continue {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				continue;
			} System.out.println(i);
		}
		/*
		 * 	A palavra reservada "continue" tem sua fun��o parecida com o break, s� que ele intgerrompe apenas aquela itera��o, repare que
		 * assim que chega no cinco, ele pula a itera��o, nesse c�digo em quest�o, n�o faz muita diferen�a, mas em c�digos maiores e mais 
		 * complexos, faz muita diferen�a;
		 */
	}
}
