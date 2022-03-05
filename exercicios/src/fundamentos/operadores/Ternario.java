package fundamentos.operadores;

public class Ternario {
	
	public static void main(String[] args) {
		
		
		double media = 8.6;
		String resultadoFinal = media >= 7.0 ? "Aprovado" : "em recupera��o";
		System.out.println("O aluno est�  " + resultadoFinal);
		
		double nota = 9.9;
		boolean bomComportamento = false;
		boolean passouPorMedia = nota >=7;
		boolean temDesconto = bomComportamento && passouPorMedia;
		String resultado = temDesconto ? "Sim" : "N�o";
		
		System.out.printf("Tem desconto ? %s ", resultado);
		
		/*
		 * Operador tern�rio "?", onde a express�o � um operando, e "Aprovado" e "em recupera��o"
		 * s�o os outros dois. E sim, � poss�vel atribuir uma equa��o em um tipo String.
		 * 
		 * Uma op��o tamb�m seria:
		 * 
		 * String resultadoParcial = media >= 5.0 ? "em recupera��o" : "reprovado";
		String resultadoFinal = media >= 7.0 ? "Aprovado" : resultadoParcial;
		
		OU
		
		String resultadoFinal = media >= 7.0 ? "Aprovado" : media >= 5.0 ? "em recupera��o" : "reprovado";
		 */
		
	}

}
