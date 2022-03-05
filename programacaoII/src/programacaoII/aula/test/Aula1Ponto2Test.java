 package programacaoII.aula.test;

import programacaoII.aula.classes.Turma;

public class Aula1Ponto2Test {
	public static void main(String[] args) {
		Turma t1 = new Turma("Sistemas de apoio a decis�o", "ARA0075");
		printClassName(t1);
	}
	private static void printClassName(Object obj) {
		try {
			System.out.println("A classe de " + obj + " � " + obj.getClass().getCanonicalName	());
			System.out.println("A classe de " + obj + " � " + obj.getClass().getName());
			System.out.println("O n�mero de modificadores de " + obj + " � " + obj.getClass().getModifiers());
			System.out.println("Os m�todos da classe de " + obj + " � " + obj.getClass().getMethods().toString());
			System.out.println("O nome da classe de " + obj + " � " + obj.getClass().getSimpleName());
			System.out.println("O nome da classe de " + obj + " � " + obj.getClass());
			System.out.println("O nome da classe de Turma " + " � " + Turma.class.getName());
			System.out.println(Class.forName("programacaoII.aula.classes.Turma"));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
