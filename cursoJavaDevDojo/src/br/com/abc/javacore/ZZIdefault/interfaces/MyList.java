package br.com.abc.javacore.ZZIdefault.interfaces;
//	A partir do Java 8, fois possível que as interfaces tenham métodos estáticos, antes disso, métodos estáticos não eram permitidos
//e todos os atributos tinham que ser estáticos e finais. Outra coisa que mudou a partir do Java 8 é que as interfaces podem agora
//ter métodos concretos e não só mais abstratos. Outra mudança que teve a partir do Java 8 foi a adição da palavra default nas
//interfaces, acontece que antes as interfaces ficavam paradas no tempo, pois caso ganhassem um novo método abstrato, todas as
//pessoas do mundo que usam tal interface teriam seus códigos quebrados, pois seriam obrigados a implementar o método abstrato,
//sendo assim, a solução foi atualizar as interfaces a partir da adição de métodos que não precisam ser implementados pelas classes
//implementadoras. Métodos default não podem ser abstratos, precisam ser concretos.  A partir dos métodos default, as classes
//utilitárias ficaram inutilizadas, pois tais classes possuiam métodos que davam suporte as interfaces, para que as classes filhas
//que implementassem tais interfaces pudessem herdam tais métodos para poderem manipular melhor os dados gerados a partir das
//interfaces, um exemplo é o Método sort() da classe Collections, que serve para ordenar as listas das interfaces, já que a List,
//Queue e afins não possuíam tais métodos, assim as classes herdeiras de Collections que implementavam as interfaces de coleções,
//como a classe ArrayList pudessem usar o método sort() para ordenarem suas listas
public interface MyList {
	static void sort() {
		System.out.println("Dentro do sort");
	}
	void add();
	default void remove() {
		System.out.println("Dentro do remove");
	}
}
