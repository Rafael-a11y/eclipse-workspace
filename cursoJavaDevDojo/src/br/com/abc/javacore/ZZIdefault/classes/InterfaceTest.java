package br.com.abc.javacore.ZZIdefault.classes;

import br.com.abc.javacore.ZZIdefault.interfaces.MyList;
//	Métodos default são invocados a partir do objeto da classe que implementa a interface, exemplo é um objeto ArrayList que
//guarda uma lista List, quando usamos o sort, chamamos o método a partir da variável que guarda a lista.
public class InterfaceTest implements MyList{
	public static void main(String[] args) {
		MyList.sort();
		new InterfaceTest().remove();
	}

	@Override
	public void add() {
		System.out.println("Dentro do add");
		
	}

}
