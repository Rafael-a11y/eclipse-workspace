package programacaoII.aula.test;
import java.lang.reflect.*;

import programacaoII.aula.classes.Turma;
public class Aula1Test {

	public Aula1Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Class cls;
		try {
			cls = Class.forName("programacaoII.aula.classes.Empresa");
//			System.out.println(cls);
			Method[] metodosClasse = cls.getDeclaredMethods();
			Method[] visibilidadeMetodos = cls.getMethods();
			String visibilidade = cls.getTypeName();
			System.out.println(visibilidade);
			for(Method method : metodosClasse) {
				System.out.println(method);
			}
			System.out.println("\n\n");
			for(Method method : metodosClasse) {
				System.out.println(method);
			}
			System.out.println("\n\n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
