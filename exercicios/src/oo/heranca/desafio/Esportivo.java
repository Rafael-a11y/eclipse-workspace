package oo.heranca.desafio;

public interface Esportivo {	//Uma calsse pode ter v�rias classes herdeiras, mas uma classe herdeira 
	public abstract void ligarTurbo();//s� pode ter uma classe pai. Essa regra muda para interfaces, uma
	void desligarTurbo();	//interface pode ter v�rias classes herdeiras e uma classe herdeira pode 
							//herdar de v�rias interfaces. Note tamb�m que em interfaces, voc� apenas
							//define o m�todo, e n�o o implementa, essa responsabilidade � da classe her-
}							//deira.

//Por padr�o, todo m�todo definido por uma interface � public e abstract, mesmo que que o programador n�o
//defina desta maneira, inpl�citamente, o m�todo ser� public e abstract. Lembrando que um m�todo abstract
//� um m�todo sem corpo.
