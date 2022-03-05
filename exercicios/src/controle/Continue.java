package controle;

public class Continue {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				continue;
			} System.out.println(i);
		}
		/*
		 * 	A palavra reservada "continue" tem sua função parecida com o break, só que ele intgerrompe apenas aquela iteração, repare que
		 * assim que chega no cinco, ele pula a iteração, nesse código em questão, não faz muita diferença, mas em códigos maiores e mais 
		 * complexos, faz muita diferença;
		 */
	}
}
