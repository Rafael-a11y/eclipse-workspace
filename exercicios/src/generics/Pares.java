package generics;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pares<C extends Number,V>{
	private final Set<Par<C, V>> itens = new LinkedHashSet<>();
	
	public void adicionar(C chave, V valor) {
		if(chave == null) return;
		Par<C,V> novoPar = new Par<C,V>(chave, valor);
		//Chama o equals()
		if(itens.contains(novoPar))
			itens.remove(novoPar);
		itens.add(novoPar);
	}
	public V getValor(C chave) {
		for(Par<C,V> par : itens) {
			if(par.getChave().equals(chave)) {
				Optional<V> valorOpcional = Optional.ofNullable(par.getValor());
				return valorOpcional.isPresent() ? valorOpcional.get() : null;
			}	
		}
		return null;
		
	}
}
