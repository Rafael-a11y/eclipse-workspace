package oo.heranca.desafio;

public interface Luxo {
	public void ligarAr();			//M�todo abstrato � aquele que n�o � implementado, somente definido
	abstract void desligarAr();
	
	default int velocidadeDoAr() {	/*a palvra reservada default antes de um m�todo inplicita que o
	mesmo n�o precisa ser executado*/
		return 1;
	}
}
