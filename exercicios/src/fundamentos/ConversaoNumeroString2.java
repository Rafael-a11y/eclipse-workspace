package fundamentos;

public class ConversaoNumeroString2 {
	
	public static void main(String[] args) {
		
		Integer num1 = 10000;
		String num1s = num1.toString();
		//OU
		int num2 = 10000;
		String num2s = Integer.toString(num2);
		//OU
		int num3 = 5;
		Integer.toString(num3);
		System.out.println(num3);
	}

}
