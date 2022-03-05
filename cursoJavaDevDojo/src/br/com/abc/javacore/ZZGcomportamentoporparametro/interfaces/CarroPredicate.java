package br.com.abc.javacore.ZZGcomportamentoporparametro.interfaces;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classes.Carro;
//Function Descriptor -> Ou seja, o que descreve a função lâmbda caso voce a use, se o método da interface funcional retorna
//valor booleano, sua função deve retornar booleano, se o método possui n parâmetros, a lâmbda deve possuir n parâmetros, se
//o tipo do parâmetro é z, o prâmetro da função deve ser z
public interface CarroPredicate {
	boolean teste(Carro carro);
	//(parâmetro) -> expressão
	//(Carro carro) -> carro.getCor().equalsIgnoreCase("verde);
}
