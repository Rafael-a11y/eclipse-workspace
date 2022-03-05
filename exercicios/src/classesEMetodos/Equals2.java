package classesEMetodos;

public class Equals2 {
	
	public static void main(String[] args) {
		
		Usuario2 u1 = new Usuario2();
		u1.nome = "Pedro Silva";
		u1.email = "pedro.silva@ezemail.com.br";
		
		Usuario2 u2 = new Usuario2();
		u2.nome = "Pedro Silva";
		u2.email = "pedro.silva@ezemail.com.br";
		
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));
		System.out.println(u2.equals(u1));
		
		//System.out.println(u2.equals(new Date()));
	}

}
