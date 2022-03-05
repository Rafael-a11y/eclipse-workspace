package streams;

import java.util.Arrays;
import java.util.List;

public class TesteBooleano {
	
	public static void main(String[] args) {
		
			Aluno a1 = new Aluno("Ana", 7.1);
			Aluno a2 = new Aluno("Luna", 6.1);
			Aluno a3 = new Aluno("Gui", 8.1);
			Aluno a4 = new Aluno("Gabi", 10);
			
			List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4);
			
			int teste = TesteBooleano.testeBooleano(5, 5);
			if(teste == 0) {
				System.out.println("O 1� n�mero � maior que o 2� ");
			}
			else if(teste == 100) {
				System.out.println("O �1 n�mero � menor que o �2");
			}
			else {
				System.out.println("Os n�meros s�o iguais");
			}
			
		}
	
	
	
	public static int  testeBooleano(int num1, int num2) {
		if (num1 > num2) return 0;
		if (num1 < num2) return 100;
		return 1;
	}

}
