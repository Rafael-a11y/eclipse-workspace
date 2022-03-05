package fundamentos;

public class ConversaoTipoPrimitivoNumerico2 {
	
	public static void main(String[] args) {
		
		double a = 1.123456788888;
		System.out.println(a);
		
		float b = (float) 1.123456788888;
		System.out.println(b);
		
		int c = 4;
		byte d = (byte) c;
		System.out.println(d);
		
		double e = 1.9999999;
		int f = (int) e;
		System.out.println(f);
	}

}
