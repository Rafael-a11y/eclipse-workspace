package oo.heranca.desafio;

public class Carro {
	
	public final int VELOCIDADE_MAXIMA;
	protected int velocidadeAtual;
	private int delta = 5;
	
	protected Carro(int velocidadeMaxima){
		this.VELOCIDADE_MAXIMA = velocidadeMaxima;
	}
	
	public void acelerar() {
		if(velocidadeAtual + getDelta() > VELOCIDADE_MAXIMA) {
			velocidadeAtual = VELOCIDADE_MAXIMA;
		}
		else {
			velocidadeAtual += getDelta();
		}
	}
	
	public void frear() {
		if(velocidadeAtual >= 5 ) {
			this.velocidadeAtual -= 5;
		}
		else {
			velocidadeAtual = 0;
		}
	}
	
	public String toString() {
		return "A velocidade atual do carro é " + velocidadeAtual + "Km/h.";
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}
	
	

}
