package classesEMetodos;

public class Usuario2 {
	
	String nome;
	String email;
	
	public boolean equals(Object objeto) {	
		if (objeto instanceof Usuario2) {
		Usuario2 outro = (Usuario2) objeto;
		boolean nomeIgual = outro.nome.equals(this.nome);
		boolean emailIgual = outro.email.equals(this.email);
		return nomeIgual && emailIgual;
		}
		else {
			return false;
		}
		//O Hashcode será abordado em outra aula 
		
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
