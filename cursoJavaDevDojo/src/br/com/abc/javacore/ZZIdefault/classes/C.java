package br.com.abc.javacore.ZZIdefault.classes;
//	Uma classe sempre vai ter prefer�ncia sobre as outras interfaces. Uma sub interface, ou seja, que � filha de outra interface
//sempre ter� mais prefer�ncia sobre a super, ou seja, caso uma classe chame um m�todo default de uma super e sub classe, o m�tod
//que ser� chamado � a da sub classe, pois este � mais espec�fico.
import br.com.abc.javacore.ZZIdefault.interfaces.A;
import br.com.abc.javacore.ZZIdefault.interfaces.B;
import br.com.abc.javacore.ZZIdefault.interfaces.D;

public class C implements A, B{
	public static void main(String[] args) {
		new C().oi();
		
	}
	public C() {
		// TODO Auto-generated constructor stub
	}
//	Sintaxe introduzida a partir do Java 8, como C implementa as interfaces A e B, e ambas possuem um m�todo de mesma assinatura,
//	a solu��o foi especificar o m�todo que deve ser chamado. Mas caso sejam m�todos sobrescritos por serem abstratos, ent�o voc�
//	s� poder� sobrescrever um dos m�todos, pois s�o as mesmas assinaturas, ou seja, n�o � uma boa pr�tica.
	 
//	public void oi() {
//		B.super.oi();
//	}
	@Override
	public void oi() {
		System.out.println("dentro do oi de c");
		
	}

}
