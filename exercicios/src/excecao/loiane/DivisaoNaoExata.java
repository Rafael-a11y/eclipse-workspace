package excecao.loiane;

public class DivisaoNaoExata extends Exception {

	private int numerador;
	private int denominador;
	
	public DivisaoNaoExata(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		return "Resultado de " + numerador + "/" + denominador + " não é um inteiro!";
	}
	
	
	
	
	
	
	
}
