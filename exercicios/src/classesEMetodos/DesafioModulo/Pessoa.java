package classesEMetodos.DesafioModulo;

public class Pessoa {
	
	String nomePessoa;
    double  pesoPessoa;
    double resultado;
    final String formato = "\nO peso atual do cliente é %.2fKL";
    String g;
	
	Pessoa(){
		
	}
	Pessoa (String nome, double peso){
		nomePessoa = nome;
		pesoPessoa = peso;
	}
	void comer(Comida comida) {
		if(comida != null) {
			pesoPessoa += comida.pesoComida;
		}
	}
	String Apresentar() {
		 return "Olá, meu nome é "+ nomePessoa + ", e peso " + pesoPessoa + "Kilogramas.";
	}
//	 double comer(Pessoa p1, Comida c1, Comida c2) {
//		 pesoPessoa += c1.pesoComida + c2.pesoComida;
//		return  pesoPessoa;
//	}
//	 String imprimirPesoComComida () {
//		return String.format(formato, pesoPessoa);
		
//	}
	
	 /*
	  * letras em itálico significxa que tal objeto ou método é estático, pertence a classe, e quando tem traço mais grosso, trata-se de
	  * uma constante. Uma variável local, isto é: declarada dentro do método, não pode ser acessada em outro método,
	  * somente se eu modificá-la como estatic, poederei acessa-la fora. É nescessário usar parâmetro.atrinbuto desejado
	  * para acessar esse atributo de outra classe no método. Pelo que eu entendi, o atributo neste caso, virou um
	  * membro do parâmetro
	  */
}
