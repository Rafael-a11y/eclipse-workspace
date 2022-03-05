package TiposDeDados;

import oo.polimorfismo.Pessoa;

public class StringQueMuda {

	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("06763614128");
		sb1.insert(3, ".").insert(7, ".").insert(11, "-");
		boolean equacao = 3 + 3 == 7;
		sb1.append(" este");
		sb1.append(" é meu CPF! ");
		sb1.append(equacao);
		System.out.println(sb1.toString());
		
		StringBuffer sb2 = new StringBuffer(60);
		System.out.println(sb2);
		
		StringBuffer sb3 = new StringBuffer(sb1);
		sb3.append(". E meu nome é Mark");
		System.out.println(sb3);
		
		StringBuffer sb4 = new StringBuffer();
		sb4.append(sb3);
		sb4.delete(0, 37);
		System.out.println(sb4);
		
		StringBuilder sb5 = new StringBuilder("O peso dele é de ");
		sb5.append(new Pessoa(75.6).getPeso()).append(" kilogramas").insert(sb5.length(), '!');
		System.out.println(sb5);
		
		StringBuilder sb6 = new StringBuilder("SubiNoÔnibus  ovo");
		sb6.reverse().reverse();
		System.out.println(sb6);
		
		StringBuilder sb7 = new StringBuilder("Certificação Java");
		System.out.println(sb7.substring(13, sb7.length()));
		System.out.println(sb7.subSequence(0, sb7.length()));
		System.out.println(sb7.length());
		System.out.println(sb7);
	}
}
