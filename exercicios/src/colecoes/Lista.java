package colecoes;
import java.util.ArrayList;
import java.util.List;
public class Lista {
public static void main(String[] args) {
	
	List<Usuario> Lista = new ArrayList <>();
	
	Usuario u1 = new Usuario("Ana");		//Crio um novo objeto de forma, digamos... mais padrão
	Lista.add(u1);							//Adiciono esse usuário recém criado a minha lista
	Lista.add(new Usuario("Carlos"));
	Lista.add(new Usuario("Lia"));		//Ou então crio um novo usuário ao mesmo tempo que o											//adiciono a lista, um método dentro do outro
	Lista.add(new Usuario("Bia"));		//adiciono a minha lista, um método dentro do outro
	Lista.add(new Usuario("Manu"));
	
	System.out.println(Lista.get(3));	//Acessa pelo índice
	
	System.out.println(">>>>>> " + Lista.remove(1));	//Não se engane, este foi removido
	System.out.println(Lista.remove(new Usuario("Manu")));
	
	System.out.println("Tem? " + Lista.contains(new Usuario ("Lia")));
	System.out.println(Lista.contains(u1));
	
	for(Usuario u: Lista) {
		System.out.println(u.nome);
	}
	/*List, ao imprimi-la, precisa especificar que quer o membro dela,
	 * no caso, nome. Estrutura do List não utilizam HashCode. Ao comentar
	 * equals e HashCode, só deu como verdadeiro a comparação por endereço
	 * de memória (linha 22, System.out.println(Lista.contains(u1)))*/				
	
}
}
 
