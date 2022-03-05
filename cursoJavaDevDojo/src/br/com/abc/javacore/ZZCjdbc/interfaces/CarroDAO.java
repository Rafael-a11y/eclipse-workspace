package br.com.abc.javacore.ZZCjdbc.interfaces;

import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Carro;
import br.com.abc.javacore.ZZCjdbc.classes.Comprador;

//Interfaces n�o possuem construtores mas podem ter m�todos e atributos, os atributos podem ser est�ticos e por padr�o s�o
//finais
public interface CarroDAO {

	void save(Carro carro);

	Comprador searchById(Integer id);

	List<Carro> searchByName(String nome);

	List<Carro> selectAll();

	void update(Carro carro);

	void delete(Carro carro);
}
