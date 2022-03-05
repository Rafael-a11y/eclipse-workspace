package br.com.abc.javacore.Passertions.test;

public class AssertTest {

	public static void main(String[] args) {
		
		diasDaSemana(4);
	}
	
	private static void calculaSalario(double salario) {
		assert salario > 0 : "O sal�rio n�o deve ser negativo, o sal�rio"
				+ " veio: " + salario;
		System.out.println("Sal�rio calculado");
	}
	
	public static void calcSalario(double salario) {
		if(salario < 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void diasDaSemana(int dia) {
		switch(dia) {
			case 1 : {
				System.out.println("Domingo"); break;
			}
			case 2 : {
				System.out.println("Segunda-feira"); break;
			}
			case 3 : {
				System.out.println("Ter�a-feira"); break;
			}
			case 4 : {
				System.out.println("Quarta-feira"); break;
			}
			case 5 : {
				System.out.println("Quinta-feira"); break;
			}
			case 6 : {
				System.out.println("Hoje � Sexta-feira"); break;
			}
			case 7: {
				System.out.println("S�bado, dia de ressaca..."); break;
			}
			default : assert false;
		}
	}
	
	public static double calcSalario2(double salario) {
		
		if(salario == 1200) {
			return salario;
		}
		return calcSalario2(salario + 100);
	}

}
