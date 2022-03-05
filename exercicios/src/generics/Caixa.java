package generics;
/*Primeira observação é que sempre que você quiser que a classe tenha uma propriedade genérica,
 * deve declarar o generics na frente do nome da classe, ou seja, sempre que você for usar generics use
 * a declaração deste no nome da classe. Isso porque você deve declarar sempre que haverá um tipo,
 * então mesmo que apenas um atributo seja genérico, você deve declarar generics logo no nome,
 * pois estará declarando que haverá um tipo 
 * 
 * Lembrar de refazer este exercício porém especificando um tipo como String por exemplo e ver
 * o comportamento que terei de resultado :)
 * 
 * E se eu querer que a classe tenha um apropriedade que não seja genérica?*/
public class Caixa<T> {

	private T coisa;
	private int numero;
	
	public void guardar(T coisa) {
		this.coisa = coisa;
	}
	public T abrir() {
		return this.coisa;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
