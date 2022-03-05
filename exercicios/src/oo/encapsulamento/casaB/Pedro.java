package oo.encapsulamento.casaB;
import oo.encapsulamento.casaA.Ana;
public class Pedro extends Ana {
 
 
	void testeAcesso() {
		System.out.println(new Ana().todosSabem); 
		System.out.println(formaDeFalar);//Por se tratar de um atributo transmitido por herança, eu 
	}									//não preciso instanciar uma Ana para acessar tal atributo, já
										//para todosSabem, por se tratar de um atributo public, também
}										//posso acessá-lo diretamente, sem precisar criar uma instância
										//Ana, embora dessa maneira também seja possível. Em relação a
										//facoDentroDeCasa, tal atributo só seria transmitido por
										//herança, se Pedro estivesse no mesmo pacote
