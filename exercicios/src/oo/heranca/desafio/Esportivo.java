package oo.heranca.desafio;

public interface Esportivo {	//Uma calsse pode ter várias classes herdeiras, mas uma classe herdeira 
	public abstract void ligarTurbo();//só pode ter uma classe pai. Essa regra muda para interfaces, uma
	void desligarTurbo();	//interface pode ter várias classes herdeiras e uma classe herdeira pode 
							//herdar de várias interfaces. Note também que em interfaces, você apenas
							//define o método, e não o implementa, essa responsabilidade é da classe her-
}							//deira.

//Por padrão, todo método definido por uma interface é public e abstract, mesmo que que o programador não
//defina desta maneira, inplícitamente, o método será public e abstract. Lembrando que um método abstract
//é um método sem corpo.
