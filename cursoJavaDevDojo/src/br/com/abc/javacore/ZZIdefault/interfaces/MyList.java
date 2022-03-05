package br.com.abc.javacore.ZZIdefault.interfaces;
//	A partir do Java 8, fois poss�vel que as interfaces tenham m�todos est�ticos, antes disso, m�todos est�ticos n�o eram permitidos
//e todos os atributos tinham que ser est�ticos e finais. Outra coisa que mudou a partir do Java 8 � que as interfaces podem agora
//ter m�todos concretos e n�o s� mais abstratos. Outra mudan�a que teve a partir do Java 8 foi a adi��o da palavra default nas
//interfaces, acontece que antes as interfaces ficavam paradas no tempo, pois caso ganhassem um novo m�todo abstrato, todas as
//pessoas do mundo que usam tal interface teriam seus c�digos quebrados, pois seriam obrigados a implementar o m�todo abstrato,
//sendo assim, a solu��o foi atualizar as interfaces a partir da adi��o de m�todos que n�o precisam ser implementados pelas classes
//implementadoras. M�todos default n�o podem ser abstratos, precisam ser concretos.  A partir dos m�todos default, as classes
//utilit�rias ficaram inutilizadas, pois tais classes possuiam m�todos que davam suporte as interfaces, para que as classes filhas
//que implementassem tais interfaces pudessem herdam tais m�todos para poderem manipular melhor os dados gerados a partir das
//interfaces, um exemplo � o M�todo sort() da classe Collections, que serve para ordenar as listas das interfaces, j� que a List,
//Queue e afins n�o possu�am tais m�todos, assim as classes herdeiras de Collections que implementavam as interfaces de cole��es,
//como a classe ArrayList pudessem usar o m�todo sort() para ordenarem suas listas
public interface MyList {
	static void sort() {
		System.out.println("Dentro do sort");
	}
	void add();
	default void remove() {
		System.out.println("Dentro do remove");
	}
}
