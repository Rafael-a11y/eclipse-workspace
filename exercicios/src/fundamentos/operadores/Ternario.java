package fundamentos.operadores;

public class Ternario {
	
	public static void main(String[] args) {
		
		
		double media = 8.6;
		String resultadoFinal = media >= 7.0 ? "Aprovado" : "em recuperação";
		System.out.println("O aluno está  " + resultadoFinal);
		
		double nota = 9.9;
		boolean bomComportamento = false;
		boolean passouPorMedia = nota >=7;
		boolean temDesconto = bomComportamento && passouPorMedia;
		String resultado = temDesconto ? "Sim" : "Não";
		
		System.out.printf("Tem desconto ? %s ", resultado);
		
		/*
		 * Operador ternário "?", onde a expressão é um operando, e "Aprovado" e "em recuperação"
		 * são os outros dois. E sim, é possível atribuir uma equação em um tipo String.
		 * 
		 * Uma opção também seria:
		 * 
		 * String resultadoParcial = media >= 5.0 ? "em recuperação" : "reprovado";
		String resultadoFinal = media >= 7.0 ? "Aprovado" : resultadoParcial;
		
		OU
		
		String resultadoFinal = media >= 7.0 ? "Aprovado" : media >= 5.0 ? "em recuperação" : "reprovado";
		 */
		
	}

}
