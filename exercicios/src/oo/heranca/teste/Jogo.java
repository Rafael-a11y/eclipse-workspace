package oo.heranca.teste;

import oo.heranca.Direcao;
import oo.heranca.Heroi;
import oo.heranca.Monstro;

public class Jogo {
	public static void main(String[] args) {
		
		Monstro monstro = new Monstro();
		System.out.println(monstro.x);
		System.out.println(monstro.y);
		monstro.x = 10;
		monstro.y = 10;
		
		Heroi heroi = new Heroi(10, 11);
		
		System.out.println("Monstro tem => " + monstro.vida);
		System.out.println("Herói twm => " + heroi.vida);
		
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		monstro.andar(Direcao.NORTE);
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
//		j1.andar(Direcao.NORTE);//O atributo de ENUM é fornecido a partir do ENUM, COM NOTAÇÃO PONTO.
//		j1.andar(Direcao.LESTE);
//		j1.andar(Direcao.NORTE);
//		j1.andar(Direcao.LESTE);
		System.out.println("Monstro tem => " + monstro.vida);
		System.out.println("Herói tem => " + heroi.vida);
	}

}
