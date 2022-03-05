package colecoes2;

import java.util.LinkedList;
import java.util.Queue;

public class Fila2 {
	
	public static void main(String[] args) {
	
	
	Queue<String> fila = new LinkedList<>();
	
	fila.add("Ana");
	fila.offer("Bia");
	fila.add("Carlos");
	fila.offer("Daniel");
	fila.add("Rafaela");
	fila.offer("Gui");
	
	System.out.println(fila.peek());
	System.out.println(fila.peek());
	System.out.println(fila.element());
	System.out.println(fila.element());
	
	System.out.println(fila.poll());
	System.out.println(fila.remove());
	System.out.println(fila.poll());
	System.out.println(fila.poll());
	System.out.println(fila.poll());
	System.out.println(fila.poll());
	System.out.println(fila.poll());
	System.out.println(fila.poll());
	System.out.println(fila.remove());
}
}
