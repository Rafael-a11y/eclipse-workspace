package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo, Luxo {	//Caso a classe herde de mais de uma in-
	private boolean ligarTurbo;	//valor padr�o � false		//terface, basta usar a v�rgula e p�r o nome
	private boolean ligarAr;	//VaLor padr�o � false		//da interface na frente.
	
	public Ferrari(){									
		this(315);										
	}
	
	public Ferrari(int velocidadeMaxima){
		super(velocidadeMaxima);
		setDelta(15);
	}
	
	@Override
	public void ligarTurbo() {	
		setDelta(35);			//A partir da palavra reservada implements, a classe Ferrari se torna
		ligarTurbo = true;	//respons�vel por implementar os m�todos da interface Esportivo, repare que
	}						//eu declaro novamente o m�todo ligarTurbo(), sendo que este j� foi declara-
							//do na interface Esportivo.
	@Override
	public void desligarTurbo() {
		setDelta(15);			//Implementa��o do m�todo desligarTurbo(), outra observa��o � que os
		ligarTurbo = false;	//m�todos implementados de uma interface obrigat�riamente precisam ser 
	}						//public.
	
	@Override
		public void ligarAr() {
			ligarAr = true;			//M�todo da interface Luxo.
		}
	
	@Override
		public void desligarAr() {
			ligarAr = false; 		//M�todo da interface Luxo
		}
	
	@Override
		public int getDelta() {	//Um m�todo sobreescrito � conectado com o m�todo gen�rico da classe pai
			if(ligarTurbo && !ligarAr) {
				return 35;					//Este m�todo altera o valor de delta a partir de condi��es
			}								//espec�ficas, o m�todo getDelta gen�rico obt�m o valor de 
			else if(ligarTurbo && ligarAr) {	//delta, e o m�todo getDelta espec�fico de Ferrari alte-
				return 30;						//ra o valor de delta, pois se trata de um polimorfismo
			}									//est�tico (sobrecarga), pois o Java sabe que se trata
			else if(!ligarTurbo && !ligarAr) {	//do mesmo m�todo, s� que sobreescrito, por isso, mesmo
				return 20;						//sem apontar expl�citamente para o m�todo da classe pai
			}									//ainda assim existe uma conex�o inpl�cita, mesmo que o 
			else {								// getDelta espec�fico e o getDelta padr�o apenas retor-
				return 15;						//nam o valor de delta, h� uma altera��o inpl�cita do
			}									//valor de delta.
		}
	
//Voc� pode invocar o m�todo dda classe pai, mas n�o substituir o construtor//da classe pai, somente
//cham�-lo
	}
	
	

