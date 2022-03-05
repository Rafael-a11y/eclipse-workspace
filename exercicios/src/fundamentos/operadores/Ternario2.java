package fundamentos.operadores;

public class Ternario2 {
	
	public static void main(String[] args) {
		
		double media = 8.6;
		//String resultadoParcial = media >= 5.0 ? "em recuperação" : "Reprovado";
		String resultadoFinal = media >= 7.0 ? "Aprovado" : "Recuperação";
		System.out.println("O aluno está " + resultadoFinal);
		
		double nota = 9.9;
		boolean bomComportamento = false;
		boolean passouPorMedia = nota >=7;
		boolean temDesconto = bomComportamento && passouPorMedia;
		String resultado = temDesconto ? "sim" : "não";
		
		System.out.println("Tem desconto ? " + resultado);
		
		
	}

}
