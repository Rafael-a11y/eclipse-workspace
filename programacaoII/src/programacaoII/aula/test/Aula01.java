package programacaoII.aula.test;

import programacaoII.aula.classes.Turma;

public class Aula01 {

	public static void main(String[] args) {
		Turma[] arrayTurma = {new Turma("ProgramaçãoII", "CCT0075"), new Turma("POO em Java", "ARA0075")};
		arrayChar();
		System.out.println();
		arrayDouble();
		System.out.println();
		arrayGenerico(arrayTurma);
		System.out.println();
		System.out.println(retornoGenerico(new Turma("Programacão2", "ARA0097")));
}
	public static void arrayChar() {
		char[] arrayChar = {'a','b','c','d','e','f'};
		for(char character : arrayChar) {
			System.out.println(character);
		}
	}
	public static void arrayDouble() {
		double[] arrayDouble = {1,2,3,4,5,6,7,8,9,10};
		for(double num : arrayDouble) {
			System.out.println(num);
		}
	}
	//O símbolo pode ser qualquer um, desde que esteja dentro do <> e antes do tipo, Você deve usar o Generics para indicar
	//que irá fornecer um objeto de qualquer tipo para o método, mas não quer dizer retorno
	 public static <T> void arrayGenerico(T[] elemento) {
		System.out.println("Array genérico");
		for(T element : elemento) {
			System.out.println(element);
		}
	}
	 public static <T, R> R retornoGenerico(R r){
		 return r;
	 }

}
