package oo.encapsulamento.casaA;

public class Paulo {

	Ana esposa = new Ana();//O objeto precisa estar criado para eu poder acessar a outra classe, não
	int idade = 43;			//adianta somente ter o atributo de mesmo tipo.
	
	void testeAcessos() {
		System.out.println(esposa.facoDentroDeCasa);
		System.out.println(esposa.formaDeFalar);
		System.out.println(esposa.todosSabem);
		
	}
}
