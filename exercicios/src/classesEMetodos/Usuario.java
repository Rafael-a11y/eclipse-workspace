package classesEMetodos;

public class Usuario {
	String nome;
	String email;
	
	
	
		public boolean equals(Object objeto) {
		
			if (objeto instanceof Usuario ) {
					Usuario outro = (Usuario) objeto;
					
					boolean nomeIgual = outro.nome.equals( this.nome);		//N�o � boa pr�tica usar ==, mas
					boolean emailIgual = outro.email.equals(this.email);	//sim equals
					
					return nomeIgual && emailIgual;
			}
			else 							{
					return false;
			}
			/*Falta o hashcode, ser� feito em outra aula */
	}
		public int hashCode() {
			return 0;
		}
}
