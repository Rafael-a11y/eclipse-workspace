package excecao;

public class Causa {
	
	public static void main(String[] args) {
		
		try {
			metodoA(null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			if(e.getMessage() == null) {
				System.out.println(e.getCause().getMessage());
			}
		}
	}
	
	static void metodoA(Aluno aluno) {
		try {
			metodoB(aluno);
		} catch (Exception causa) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(causa);
		}
	}
	
	static void metodoB(Aluno aluno) {
		if(aluno == null) {
			throw new NullPointerException("O aluno está nulo!");
		}
		System.out.println(aluno.getNome());
	}

}
