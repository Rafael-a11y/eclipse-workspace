package generics;
/*Primeira observa��o � que sempre que voc� quiser que a classe tenha uma propriedade gen�rica,
 * deve declarar o generics na frente do nome da classe, ou seja, sempre que voc� for usar generics use
 * a declara��o deste no nome da classe. Isso porque voc� deve declarar sempre que haver� um tipo,
 * ent�o mesmo que apenas um atributo seja gen�rico, voc� deve declarar generics logo no nome,
 * pois estar� declarando que haver� um tipo 
 * 
 * Lembrar de refazer este exerc�cio por�m especificando um tipo como String por exemplo e ver
 * o comportamento que terei de resultado :)
 * 
 * E se eu querer que a classe tenha um apropriedade que n�o seja gen�rica?*/
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
