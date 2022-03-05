package br.com.abc.javacore.ZZCjdbc.interfaces;

import java.util.List;

import br.com.abc.javacore.ZZCjdbc.classes.Carro;
import br.com.abc.javacore.ZZCjdbc.classes.Comprador;

//Interfaces não possuem construtores mas podem ter métodos e atributos, os atributos podem ser estáticos e por padrão são
//finais
public interface CarroDAO {

	void save(Carro carro);

	Comprador searchById(Integer id);

	List<Carro> searchByName(String nome);

	List<Carro> selectAll();

	void update(Carro carro);

	void delete(Carro carro);
}
