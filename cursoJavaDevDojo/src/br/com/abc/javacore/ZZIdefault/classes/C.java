package br.com.abc.javacore.ZZIdefault.classes;
//	Uma classe sempre vai ter preferência sobre as outras interfaces. Uma sub interface, ou seja, que é filha de outra interface
//sempre terá mais preferência sobre a super, ou seja, caso uma classe chame um método default de uma super e sub classe, o métod
//que será chamado é a da sub classe, pois este é mais específico.
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
//	Sintaxe introduzida a partir do Java 8, como C implementa as interfaces A e B, e ambas possuem um método de mesma assinatura,
//	a solução foi especificar o método que deve ser chamado. Mas caso sejam métodos sobrescritos por serem abstratos, então você
//	só poderá sobrescrever um dos métodos, pois são as mesmas assinaturas, ou seja, não é uma boa prática.
	 
//	public void oi() {
//		B.super.oi();
//	}
	@Override
	public void oi() {
		System.out.println("dentro do oi de c");
		
	}

}
