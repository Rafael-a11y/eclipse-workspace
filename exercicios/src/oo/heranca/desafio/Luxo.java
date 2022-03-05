package oo.heranca.desafio;

public interface Luxo {
	public void ligarAr();			//Método abstrato é aquele que não é implementado, somente definido
	abstract void desligarAr();
	
	default int velocidadeDoAr() {	/*a palvra reservada default antes de um método inplicita que o
	mesmo não precisa ser executado*/
		return 1;
	}
}
