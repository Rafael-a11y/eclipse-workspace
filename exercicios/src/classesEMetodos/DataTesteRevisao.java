package classesEMetodos;

public class DataTesteRevisao {
	
	public static void main(String[] args) {
		
		DataRevisao d1 = new DataRevisao(03, 07, 2020);
		DataRevisao d2 = new DataRevisao();
		d2 = d1;
//		d2.dia = 12;
//		d1.mes = 8;
		d2 = new DataRevisao();
		System.out.printf("A data � %d/%d/%d ", d1.dia, d1.mes, d1.ano);
		System.out.printf("\nA data � %d/%d/%d ", d2.dia, d2.mes, d2.ano);
	}
		/*
		 * Atribui��o por refer�ncia, diferente dos tipos primitivos, os objetos 
		 * tem uma atribui��o diferente, ao d2 = d1, d2 = passa apontar o mesmo o-
		 * bjeto que d1, isso porqu� o valor que eles possuem � o endere�o de me-
		 * m�ria que aponta para esse objeto (na mem�ria), sendo assim, d1 e d2 
		 * compartilham o mesmo objeto. Quando d2 recebeu new DataRevisao, um ou-
		 * tro objeto de valor padrao 0 foi criado. Quando um objeto n�o � mais
		 * referenciado, o coletor de lixo do java exclui inplicitamente aquele
		 * objeto 
		 *  
		 */
}
