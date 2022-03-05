package br.com.abc.javacore.ZZIdefault.classes;

import br.com.abc.javacore.ZZIdefault.interfaces.MyList;
//	M�todos default s�o invocados a partir do objeto da classe que implementa a interface, exemplo � um objeto ArrayList que
//guarda uma lista List, quando usamos o sort, chamamos o m�todo a partir da vari�vel que guarda a lista.
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
