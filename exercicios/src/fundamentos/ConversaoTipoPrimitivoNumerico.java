package fundamentos;

public class ConversaoTipoPrimitivoNumerico {
	
	public static void main(String[] args) {
		
	double a = 1;
	System.out.println(a);
	
	float b = (float) 1.23456788888;
	System.out.println(b);
	
	int c = 240;
	byte d = (byte) c;
	System.out.println(d);
	
	double e = 130;
	int f = (int) e;
	System.out.println(f);
	/*
	 * Na linha 7 houve uma conversão inplícita de de valor int para
	 * double.
	 * Na linha 10 houve uma conversão explícita (Cast)
	 * Na linha 18 houve uma conversão explícita de double para byte,
	 * mesmo que o tipo declarado inicialmente seja int.
	 * O tipo double suporta de -128 até 127. 
	 */
	}
}
