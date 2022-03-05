package generics;

public class Par<C,V> {

	private C key;
	private V valor;
	
	public Par() {
		
	}
	public Par(C chave, V valor) {
		this.key = chave;
		this.valor = valor;
	}
	public C getChave() {
		return key;
	}
	public void setChave(C chave) {
		this.key = chave;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Par<?, ?> other = (Par<?, ?>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}
