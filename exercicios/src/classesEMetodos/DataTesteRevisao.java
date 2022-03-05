package classesEMetodos;

public class DataTesteRevisao {
	
	public static void main(String[] args) {
		
		DataRevisao d1 = new DataRevisao(03, 07, 2020);
		DataRevisao d2 = new DataRevisao();
		d2 = d1;
//		d2.dia = 12;
//		d1.mes = 8;
		d2 = new DataRevisao();
		System.out.printf("A data é %d/%d/%d ", d1.dia, d1.mes, d1.ano);
		System.out.printf("\nA data é %d/%d/%d ", d2.dia, d2.mes, d2.ano);
	}
		/*
		 * Atribuição por referência, diferente dos tipos primitivos, os objetos 
		 * tem uma atribuição diferente, ao d2 = d1, d2 = passa apontar o mesmo o-
		 * bjeto que d1, isso porquê o valor que eles possuem é o endereço de me-
		 * mória que aponta para esse objeto (na memória), sendo assim, d1 e d2 
		 * compartilham o mesmo objeto. Quando d2 recebeu new DataRevisao, um ou-
		 * tro objeto de valor padrao 0 foi criado. Quando um objeto não é mais
		 * referenciado, o coletor de lixo do java exclui inplicitamente aquele
		 * objeto 
		 *  
		 */
}
