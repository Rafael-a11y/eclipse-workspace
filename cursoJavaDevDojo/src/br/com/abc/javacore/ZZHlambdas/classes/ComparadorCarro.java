package br.com.abc.javacore.ZZHlambdas.classes;
/*O método compareTo() é muito importante, pois é ele que determina se o método é comparator.*/
public class ComparadorCarro {
	public static int comparePorCor(Carro c1, Carro c2) {
		return c1.getCor().compareTo(c2.getCor());
	}
	public int comparePorAno(Carro c1, Carro c2) {
		Integer ano = c1.getAno();
		return ano.compareTo(c2.getAno());
	}
}
