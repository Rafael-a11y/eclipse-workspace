package colecoes2;

import java.util.ArrayList;
import java.util.List;

public class Lista2 {

	public static void main(String[] args) {
		
		List<Usuario2> lista = new ArrayList<Usuario2>();
		
		//List não usa hashcode!
		
		Usuario2 u1 = new Usuario2("Ana");
		lista.add(u1);
		
		lista.add(new Usuario2("Carlos"));
		lista.add(new Usuario2("Lia"));
		lista.add(new Usuario2("Bia"));
		lista.add(new Usuario2("Manu"));
		System.out.println(lista.get(3));
		
		System.out.println(">>>>>> " + lista.remove(1));
		System.out.println("Removeu? " + lista.remove(new Usuario2("Manu")));
		System.out.println("Tem? " + lista.contains(new Usuario2("Lia")));
		System.out.println("Tem? " + lista.contains(u1));
		
		for(Usuario2 u: lista) {
			System.out.println(u.nome);	
		}
	}
}
