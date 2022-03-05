package programacaoII.aula.classes;

public class Turma {
	private String nome;
	private String matricula;
	protected String sobrenome;
	
	public Turma(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	public static void nada() {
		
	}

	@Override
	public String toString() {
		return "Turma { nome = " + nome + ", matricula = " + matricula + " }";
	}
	

}
