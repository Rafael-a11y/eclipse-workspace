package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo, Luxo {	//Caso a classe herde de mais de uma in-
	private boolean ligarTurbo;	//valor padrão é false		//terface, basta usar a vírgula e pôr o nome
	private boolean ligarAr;	//VaLor padrão é false		//da interface na frente.
	
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
		ligarTurbo = true;	//responsável por implementar os métodos da interface Esportivo, repare que
	}						//eu declaro novamente o método ligarTurbo(), sendo que este já foi declara-
							//do na interface Esportivo.
	@Override
	public void desligarTurbo() {
		setDelta(15);			//Implementação do método desligarTurbo(), outra observação é que os
		ligarTurbo = false;	//métodos implementados de uma interface obrigatóriamente precisam ser 
	}						//public.
	
	@Override
		public void ligarAr() {
			ligarAr = true;			//Método da interface Luxo.
		}
	
	@Override
		public void desligarAr() {
			ligarAr = false; 		//Método da interface Luxo
		}
	
	@Override
		public int getDelta() {	//Um método sobreescrito é conectado com o método genérico da classe pai
			if(ligarTurbo && !ligarAr) {
				return 35;					//Este método altera o valor de delta a partir de condições
			}								//específicas, o método getDelta genérico obtém o valor de 
			else if(ligarTurbo && ligarAr) {	//delta, e o método getDelta específico de Ferrari alte-
				return 30;						//ra o valor de delta, pois se trata de um polimorfismo
			}									//estático (sobrecarga), pois o Java sabe que se trata
			else if(!ligarTurbo && !ligarAr) {	//do mesmo método, só que sobreescrito, por isso, mesmo
				return 20;						//sem apontar explícitamente para o método da classe pai
			}									//ainda assim existe uma conexão inplícita, mesmo que o 
			else {								// getDelta específico e o getDelta padrão apenas retor-
				return 15;						//nam o valor de delta, há uma alteração inplícita do
			}									//valor de delta.
		}
	
//Você pode invocar o método dda classe pai, mas não substituir o construtor//da classe pai, somente
//chamá-lo
	}
	
	

