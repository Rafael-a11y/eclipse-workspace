package controle;

public class Break {
	public static void main(String[] args) {
		
		for (int i = 0; 1 < 10;i++) {
			System.out.print("\n" + i);
			if (i == 5) {
				break;
			}
		}
		System.out.println("\nFim!");
	}

}
/*
 *	A palavra reservada "break" também pode ser usada em if, while.
 */
