package br.com.abc.javacore.Zcolecoes.classes;
/*Comparable é diferenteb de Comparator*/
public class Produto implements Comparable<Produto>{

	private String serialNumber;
	private String nome;
	private Double preco;
	private int quantidade;
	
	
	
	public Produto(String serialNumber, String nome, Double preco) {
		this.serialNumber = serialNumber;
		this.nome = nome;
		this.preco = preco;
	}

	public Produto(String serialNumber, String nome, double preco, int quantidade) {
		this.serialNumber = serialNumber;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	@Override
	public int hashCode() {
	 	final int prime = 31;
		int result = 1;
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Produto { serialNumber = " + serialNumber + ", nome = " + nome + ", preco = " + preco + ", quantidade = "
				+ quantidade + " }";
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int compareTo(Produto outroObjeto) {
		/*Retorna um int, este int será negativo se:
		 * thisObject < outroObjeto;
		 * Retorna 0 se:
		 * thisObject == outroObjeto;
		 * Retorna positivo se:
		 * thisObject > outroObjeto;*/
		
		 /*Poderia ser assim, mas eu posso simplemeste
		  * redeclarar o atributo preço como Double :)
		  * Porém, leve em consideração que tipo Wrappers
		  * consomem mais memória, então, se economizar
		  * memória for prioridade, faça desta maneira */
//		 Double p  = (Double) getPreco();
//		 return p.compareTo(outroObjeto.getPreco());
		return this.preco.compareTo(outroObjeto.preco);
	}
}