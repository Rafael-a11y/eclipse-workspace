package br.com.abc.javacore.lClassesAbstratas.test;

import br.com.abc.javacore.lClassesAbstratas.classes.Gerente;
import br.com.abc.javacore.lClassesAbstratas.classes.Vendedor;

public class FuncionarioTeste {	

	public static void main(String[] args) {
		
		Gerente g = new Gerente("Anna", "11122-2", 2000);
		Vendedor v = new Vendedor("Camila", "22211-4", 1500, 5000);
		
		v.calculaSalario();
		g.calculaSalario();
		
		System.out.println(g);
		System.out.println(v);
		
		
		
		
		
		
		
		
	}
}
