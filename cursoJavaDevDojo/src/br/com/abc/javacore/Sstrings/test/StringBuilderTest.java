package br.com.abc.javacore.Sstrings.test;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		String s = "Frase comumm";
		StringBuilder sb = new StringBuilder(16);
//		sb.append(" Uma frase comum");
//		s = s + sb.toString();
		sb.append("Uma frase comum");
		sb.append(" test");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.replace(0, sb.length(), "tset mumoc esarf amU");
		System.out.println(sb.reverse());
		System.out.println(sb);
		sb.delete(0, 16);
		System.out.println(sb);
		System.out.println(sb.insert(4, "e"));
	}

}
