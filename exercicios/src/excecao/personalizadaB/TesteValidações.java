package excecao.personalizadaB;

import excecao.Aluno;

public class TesteValidações {
	
	public static void main(String[] args) throws StringVaziaException {
		
			try {
				Aluno aluno = new Aluno("", 7);
				Validar.aluno(aluno);
				Aluno aluno2 = null;
				Validar.aluno(aluno2);

		}
			catch(StringVaziaException e){
			System.out.println(e.getMessage());
		}
			catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		catch(NumeroForaIntervaloException e){
			System.out.println(e.getMessage());
		}
//			System.out.println(aluno.getNome());
//			System.out.println(aluno.getNota());
		System.out.println("Antes de chegar ao fim!");
		System.out.println("Fim :{)"); 
	}

}
