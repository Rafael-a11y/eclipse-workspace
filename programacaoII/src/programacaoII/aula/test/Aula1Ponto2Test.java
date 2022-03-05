 package programacaoII.aula.test;

import programacaoII.aula.classes.Turma;

public class Aula1Ponto2Test {
	public static void main(String[] args) {
		Turma t1 = new Turma("Sistemas de apoio a decisão", "ARA0075");
		printClassName(t1);
	}
	private static void printClassName(Object obj) {
		try {
			System.out.println("A classe de " + obj + " é " + obj.getClass().getCanonicalName	());
			System.out.println("A classe de " + obj + " é " + obj.getClass().getName());
			System.out.println("O número de modificadores de " + obj + " é " + obj.getClass().getModifiers());
			System.out.println("Os métodos da classe de " + obj + " é " + obj.getClass().getMethods().toString());
			System.out.println("O nome da classe de " + obj + " é " + obj.getClass().getSimpleName());
			System.out.println("O nome da classe de " + obj + " é " + obj.getClass());
			System.out.println("O nome da classe de Turma " + " é " + Turma.class.getName());
			System.out.println(Class.forName("programacaoII.aula.classes.Turma"));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
