package generics;

public class CaixaObjetoTeste {
	public static void main(String[] args) {
		
		CaixaObjeto caixaA = new CaixaObjeto();
		// Object -> Double
		caixaA.guardar(2.3);
		// Double -> double
		// Object -> double
		Double coisaA = (Double) caixaA.abrir();
		System.out.println(coisaA);
		
		CaixaObjeto caixaB = new CaixaObjeto();
		caixaB.guardar("Olá");
		String coisaB = (String) caixaB.abrir();
		System.out.println(coisaB);
		
	}
}
