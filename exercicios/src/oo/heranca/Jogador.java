package oo.heranca;

public class Jogador {
public int vida = 100;
public int x;
public int y;

//	Jogador(){
//	 this(0,0);	//J� que a assinatura � o nome e os par�metros, chamar o m�todo dentro de outro,
//					//sendo que o par�metro est� vazio, � uma boa estrat�gia para manter o construtor
					//padr�o
//	}

	protected Jogador(int x, int y){
		this.x = x;
		this.y = y;
	}

	public boolean atacar(Jogador oponente) {
		
		int deltaX = Math.abs(x - oponente.x);
		int deltaY = Math.abs(y - oponente.y);
		if(deltaX == 0 && deltaY == 1) {
			oponente.vida -= 10;
			return true;
		}
		else if(deltaX == 1 && deltaY == 0) {
			oponente.vida -=10;
			return true;
		}
		else {
			return false;
		}
	}

	public boolean andar(Direcao  direcao){
		
			switch(direcao){
			case NORTE: y--; break;
			
			case LESTE: x++; break;
			
			case SUL: y++; break;
			
			case OESTE: x--; break;
				
			}
		
		return true;
	}
}
