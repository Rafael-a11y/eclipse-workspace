package br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classes.Carro;
//Function Descriptor -> Ou seja, o que descreve a fun��o l�mbda caso voce a use, se o m�todo da interface funcional retorna
//valor booleano, sua fun��o deve retornar booleano, se o m�todo possui n par�metros, a l�mbda deve possuir n par�metros, se
//o tipo do par�metro � z, o pr�metro da fun��o deve ser z
public interface CarroPredicate {
	boolean teste(Carro carro);
	//(par�metro) -> express�o
	//(Carro carro) -> carro.getCor().equalsIgnoreCase("verde);
}
