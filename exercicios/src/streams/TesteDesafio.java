package streams;

import java.util.Arrays;
import java.util.List;

public class TesteDesafio {
	public static void main(String[] args) {
		
//		Random aleatorio = new Random();
//		float valor = aleatorio.nextFloat() * 10;
//		System.out.println("O valor gerado aleatóriamente é: " + valor);
//		System.out.println(Math.floor(Math.random() * 100));
//		Random aleatorio = new Random();
//		System.out.println(aleatorio.nextInt(4 + 1));
		Aluno aluno1 = new Aluno("Rafael Souto", 8.00, 8.0, 9.50 );
		Aluno aluno2 = new Aluno("Israel Souto", 3.0, 7.0, 0.0);
//		aluno1.diciplinas.stream();
		List<Aluno> alunos = Arrays.asList(aluno1, aluno2);
		alunos.stream().filter(a -> a.nota1 >= 4).filter(Aluno.notasBoa).
		map(a -> "Parabéns " + a.nome + ", você passou!")
		.forEach(System.out::println);
	}
}
