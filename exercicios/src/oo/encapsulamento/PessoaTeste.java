package oo.encapsulamento;

public class PessoaTeste {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Pedro", "Amoedo", -45);
		
		System.out.println(p1.getNomeCompleto()); 
		System.out.println(p1);
	}

}
