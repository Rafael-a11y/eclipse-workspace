package programacaoII.aula.classes;

public class Atleta {
	
	public static enum Esporte {Tenis, Basquete, Futebol, F1};
	
	private String nome;
	private Esporte esporte;
	
	public String toString() {
		return "Atleta -> {Nome = " + this.getNome() + ", esporte = " + this.getEsporte() + ", }";
	}
	
	public Atleta(String nome, Esporte esporte) {
		this.nome = nome;
		this.esporte = esporte;
	}
	
	public String getNome() {
		return this.nome;
	}
	public Esporte getEsporte() {
		return this.esporte;
	}

}
