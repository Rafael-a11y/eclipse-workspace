package classesEMetodos.DesafioModulo;

public class Pessoa {
	
	String nomePessoa;
    double  pesoPessoa;
    double resultado;
    final String formato = "\nO peso atual do cliente � %.2fKL";
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
		 return "Ol�, meu nome � "+ nomePessoa + ", e peso " + pesoPessoa + "Kilogramas.";
	}
//	 double comer(Pessoa p1, Comida c1, Comida c2) {
//		 pesoPessoa += c1.pesoComida + c2.pesoComida;
//		return  pesoPessoa;
//	}
//	 String imprimirPesoComComida () {
//		return String.format(formato, pesoPessoa);
		
//	}
	
	 /*
	  * letras em it�lico significxa que tal objeto ou m�todo � est�tico, pertence a classe, e quando tem tra�o mais grosso, trata-se de
	  * uma constante. Uma vari�vel local, isto �: declarada dentro do m�todo, n�o pode ser acessada em outro m�todo,
	  * somente se eu modific�-la como estatic, poederei acessa-la fora. � nescess�rio usar par�metro.atrinbuto desejado
	  * para acessar esse atributo de outra classe no m�todo. Pelo que eu entendi, o atributo neste caso, virou um
	  * membro do par�metro
	  */
}
