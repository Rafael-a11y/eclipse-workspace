package colecoes;
import java.util.ArrayList;
import java.util.List;
public class Lista {
public static void main(String[] args) {
	
	List<Usuario> Lista = new ArrayList <>();
	
	Usuario u1 = new Usuario("Ana");		//Crio um novo objeto de forma, digamos... mais padr�o
	Lista.add(u1);							//Adiciono esse usu�rio rec�m criado a minha lista
	Lista.add(new Usuario("Carlos"));
	Lista.add(new Usuario("Lia"));		//Ou ent�o crio um novo usu�rio ao mesmo tempo que o											//adiciono a lista, um m�todo dentro do outro
	Lista.add(new Usuario("Bia"));		//adiciono a minha lista, um m�todo dentro do outro
	Lista.add(new Usuario("Manu"));
	
	System.out.println(Lista.get(3));	//Acessa pelo �ndice
	
	System.out.println(">>>>>> " + Lista.remove(1));	//N�o se engane, este foi removido
	System.out.println(Lista.remove(new Usuario("Manu")));
	
	System.out.println("Tem? " + Lista.contains(new Usuario ("Lia")));
	System.out.println(Lista.contains(u1));
	
	for(Usuario u: Lista) {
		System.out.println(u.nome);
	}
	/*List, ao imprimi-la, precisa especificar que quer o membro dela,
	 * no caso, nome. Estrutura do List n�o utilizam HashCode. Ao comentar
	 * equals e HashCode, s� deu como verdadeiro a compara��o por endere�o
	 * de mem�ria (linha 22, System.out.println(Lista.contains(u1)))*/				
	
}
}
 
