package oo.encapsulamento.casaB;
import oo.encapsulamento.casaA.Ana;
public class Pedro extends Ana {
 
 
	void testeAcesso() {
		System.out.println(new Ana().todosSabem); 
		System.out.println(formaDeFalar);//Por se tratar de um atributo transmitido por heran�a, eu 
	}									//n�o preciso instanciar uma Ana para acessar tal atributo, j�
										//para todosSabem, por se tratar de um atributo public, tamb�m
}										//posso acess�-lo diretamente, sem precisar criar uma inst�ncia
										//Ana, embora dessa maneira tamb�m seja poss�vel. Em rela��o a
										//facoDentroDeCasa, tal atributo s� seria transmitido por
										//heran�a, se Pedro estivesse no mesmo pacote
